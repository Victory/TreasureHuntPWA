package org.dfhu.thpwa;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.dfhu.thpwa.approutes.GetUserInfoRoute;
import org.dfhu.thpwa.approutes.LoginRoute;
import org.dfhu.thpwa.approutes.RegisterRoute;
import org.dfhu.thpwa.context.ThConfig;
import org.dfhu.thpwa.morphs.query.UserQuery;
import org.dfhu.thpwa.routing.Route;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.Properties;

class Application {
  private final Properties properties;

  Application(Properties properties) {
    this.properties = properties;
  }

  private static void addRoute(Route route) {
    route.addRoute();
  }

  void init() {
    ThConfig config = getConfig();
    Datastore datastore = buildDatastore(config);
    UserQuery userQuery = new UserQuery(datastore);
    setRoutes(config, datastore, userQuery);
  }

  private ThConfig getConfig() {
    boolean isDev = properties.getProperty("isDev").equals("true");
    String mongoUri = properties.getProperty("mongoUri");
    return new ThConfig(isDev, mongoUri);
  }

  private void setRoutes(final ThConfig config, Datastore datastore, UserQuery userQuery) {
    addRoute(new GetUserInfoRoute());
    addRoute(new LoginRoute());
    addRoute(new RegisterRoute(datastore, userQuery));
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
