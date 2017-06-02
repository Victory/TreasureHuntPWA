package org.dfhu.thpwa;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.dfhu.thpwa.approutes.GetUserInfoRoute;
import org.dfhu.thpwa.approutes.LoginRoute;
import org.dfhu.thpwa.approutes.RegisterRoute;
import org.dfhu.thpwa.context.ThConfig;
import org.dfhu.thpwa.context.ThSessionProvider;
import org.dfhu.thpwa.morphs.query.UserQuery;
import org.dfhu.thpwa.routing.Route;
import org.dfhu.thpwa.util.PasswordHash;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.Properties;

class Application {
  private final Properties properties;

  private final ThSessionProvider thSessionProvider = new ThSessionProvider();

  Application(Properties properties) {
    this.properties = properties;
  }

  private void addRoute(Route route) {
    route.setThSessionProvider(thSessionProvider);
    route.addRoute();
  }

  void init() {
    ThConfig config = getConfig();
    Datastore datastore = buildDatastore(config);
    UserQuery userQuery = new UserQuery(datastore);
    PasswordHash passwordHash = new PasswordHash();
    setRoutes(config, datastore, userQuery, passwordHash);
  }

  private ThConfig getConfig() {
    boolean isDev = properties.getProperty("isDev").equals("true");
    String mongoUri = properties.getProperty("mongoUri");
    return new ThConfig(isDev, mongoUri);
  }

  private void setRoutes(final ThConfig config, Datastore datastore, UserQuery userQuery, PasswordHash passwordHash) {
    addRoute(new GetUserInfoRoute());
    addRoute(new LoginRoute(passwordHash, userQuery));
    addRoute(new RegisterRoute(passwordHash, userQuery));
  }

  private Datastore buildDatastore(ThConfig config) {
    final Morphia morphia = new Morphia();

    // tell Morphia where to find your classes
    // can be called multiple times with different packages or classes
    try {
      morphia.mapPackage("org.dfhu.thpwa.morphs");
    } catch (Throwable t) {
      throw new RuntimeException("Could not find packages: " + t.getMessage());
    }
    String uriString = config.getMongoUri();
    MongoClientURI uri = new MongoClientURI(uriString);

    // create the Datastore connecting to the default port on the local host
    Datastore datastore = morphia.createDatastore(
        new MongoClient(uri), uri.getDatabase());
    datastore.ensureIndexes();

    return datastore;
  }
}
