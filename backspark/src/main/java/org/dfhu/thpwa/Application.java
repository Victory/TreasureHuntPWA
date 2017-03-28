package org.dfhu.thpwa;

import org.dfhu.thpwa.approutes.GetUserInfo;
import org.dfhu.thpwa.context.ThConfig;
import org.dfhu.thpwa.routing.Route;

import java.util.Properties;

public class Application {
    private final Properties properties;

    public Application(Properties properties) {
        this.properties = properties;
    }

    public void init() {
        ThConfig config = getConfig();
        setRoutes(config);
    }

    private ThConfig getConfig() {
        boolean isDev = true;
        return new ThConfig(isDev);
    }

    private void setRoutes(final ThConfig config) {
        addRoute(new GetUserInfo());
    }

    private static void addRoute(Route route) {
        route.addRoute();
    }

}
