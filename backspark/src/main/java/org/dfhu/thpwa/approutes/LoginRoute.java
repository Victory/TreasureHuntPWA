package org.dfhu.thpwa.approutes;

import org.dfhu.thpwa.context.ThSession;
import org.dfhu.thpwa.morphs.UserMorph;
import org.dfhu.thpwa.morphs.query.UserQuery;
import org.dfhu.thpwa.routing.JsonResponse;
import org.dfhu.thpwa.routing.JsonRoute;
import org.dfhu.thpwa.routing.Route;
import org.dfhu.thpwa.util.PasswordHash;

public class LoginRoute extends JsonRoute implements Route {
  private static final String WRONG_USERNAME_OR_PASSWORD = "wrong username or password";
  private final UserQuery userQuery;
  private final PasswordHash passwordHash;

  public LoginRoute(PasswordHash passwordHash, UserQuery userQuery) {
    this.passwordHash = passwordHash;
    this.userQuery = userQuery;
  }

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
    Params params = getJsonParams(session, Params.class);
    UserMorph user =  userQuery.getByUserName(params.userName);
    if (user == null) {
      return new JsonResponse(false, WRONG_USERNAME_OR_PASSWORD);
    }
    if (!passwordHash.match(params.password, user.password)) {
      return new JsonResponse(false, WRONG_USERNAME_OR_PASSWORD);
    }
    return new JsonResponse(true, "logged in");
  }

  private class Params implements JsonRequest {
    String userName;
    String password;
  }
}
