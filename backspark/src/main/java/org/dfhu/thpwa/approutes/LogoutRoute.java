package org.dfhu.thpwa.approutes;

import org.dfhu.thpwa.context.ThSession;
import org.dfhu.thpwa.routing.JsonResponse;
import org.dfhu.thpwa.routing.JsonRoute;
import org.dfhu.thpwa.routing.Route;

public class LogoutRoute extends JsonRoute implements Route {
  @Override
  public String getPath() {
    return "/logout";
  }

  @Override
  public METHOD getMethod() {
    return METHOD.POST;
  }

  @Override
  public JsonResponse getJsonResponse(ThSession session) {
    session.logout();
    return new JsonResponse(false, "Stubbed to False");
  }
}
