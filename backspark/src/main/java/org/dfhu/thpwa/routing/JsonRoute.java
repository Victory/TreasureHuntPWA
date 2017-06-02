package org.dfhu.thpwa.routing;

import com.google.gson.Gson;
import org.dfhu.thpwa.context.ThSession;
import org.dfhu.thpwa.context.ThSessionProvider;
import spark.Request;
import spark.Response;
import spark.Spark;

public abstract class JsonRoute extends RouteAdder<JsonRoute> implements Route {


  private ThSessionProvider provider;

  /**
   * Get an object that you can Gson.toJson()
   */
  public abstract JsonResponse getJsonResponse(ThSession session);

  @Override
  public void doPost(RouteAdder<JsonRoute> routeAdder) {
    Spark.post("/api" + getPath(),
        "application/json",
        (req, res) -> {
          res.header("Content-Type", "application/json");
          ThSession session = getSession(req, res);
          return new Gson().toJson(getJsonResponse(session));
        });
  }

  @Override
  public void doGet(RouteAdder<JsonRoute> routeAdder) {
    Spark.get("/api" + getPath(),
        "application/json",
        (req, res) -> {
          res.header("Content-Type", "application/json");
          ThSession session = getSession(req, res);
          return new Gson().toJson(getJsonResponse(session));
        });
  }

  private ThSession getSession(Request req, Response res) {
    return getThSessionProvider().getSession(req, res);
  }

  public void setThSessionProvider(ThSessionProvider provider) {
    this.provider = provider;
  }

  private ThSessionProvider getThSessionProvider() {
    return provider;
  }

  protected  <T extends JsonRequest> T getJsonParams(ThSession session, Class<T> paramsClass) {
    return new Gson().fromJson(session.getReq().body(), paramsClass);
  }

  protected interface JsonRequest {}
}
