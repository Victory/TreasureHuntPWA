package org.dfhu.thpwa.routing;


import org.dfhu.thpwa.context.ThSessionProvider;

public interface Route {
  /**
   * Get the url pattern for this route
   */
  String getPath();

  /**
   * get the HTTP request method
   */
  METHOD getMethod();

  /**
   * Add the route to spark
   */
  void addRoute();

  void setThSessionProvider(ThSessionProvider thSessionProvider);

  enum METHOD {
    GET,
    POST
  }
}
