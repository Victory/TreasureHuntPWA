package org.dfhu.thpwa.approutes;

import org.dfhu.thpwa.context.ThSession;
import org.dfhu.thpwa.routing.JsonResponse;
import org.dfhu.thpwa.routing.JsonRoute;
import org.dfhu.thpwa.routing.Route;

public class LoginRoute extends JsonRoute implements Route {
  @Override
  public String getPath() {
    return "/login";
  }

  @Override
  public METHOD getMethod() {
    return METHOD.POST;
  }

  @Override
  public JsonResponse getJsonResponse(ThSession session) {
    return new JsonResponse(false, "stubbed to return false");
  }
}
