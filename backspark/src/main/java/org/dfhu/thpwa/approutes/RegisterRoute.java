package org.dfhu.thpwa.approutes;

import com.mongodb.DuplicateKeyException;
import org.dfhu.thpwa.auth.UserGroup;
import org.dfhu.thpwa.context.ThSession;
import org.dfhu.thpwa.morphs.UserMorph;
import org.dfhu.thpwa.morphs.query.UserQuery;
import org.dfhu.thpwa.routing.JsonResponse;
import org.dfhu.thpwa.routing.JsonRoute;
import org.dfhu.thpwa.routing.Route;
import org.dfhu.thpwa.util.PasswordHash;
import org.mongodb.morphia.Datastore;

import java.util.HashSet;

public class RegisterRoute extends JsonRoute implements Route {

  private final Datastore datastore;
  private final UserQuery userQuery;

  public RegisterRoute(Datastore datastore, UserQuery userQuery) {
    this.datastore = datastore;
    this.userQuery = userQuery;
  }

  @Override
  public String getPath() {
    return "/register";
  }

  @Override
  public METHOD getMethod() {
    return METHOD.POST;
  }

  @Override
  public JsonResponse getJsonResponse(ThSession session) {
    Params params = getJsonParams(session, Params.class);
    if (!params.password.equals(params.password2)) {
      return new JsonResponse(false, "Passwords do not match", "password-not-match");
    }
    if (params.userName == null) {
      return new JsonResponse(false, "Username and Password are Required", "username-and-password-required");
    }

    UserMorph newUser = new UserMorph();
    newUser.userName = params.userName;
    newUser.email = params.email;
    PasswordHash passwordHash = new PasswordHash();
    newUser.password = passwordHash.getHashString(params.password);
    HashSet<UserGroup> userGroups = new HashSet<>();
    userGroups.add(UserGroup.USER);
    newUser.groups = userGroups;
    try {
      datastore.save(newUser);
    } catch (DuplicateKeyException e) {
      return new JsonResponse(false, "User already exists", "duplicate");
    }

    return new JsonResponse(true, "User added");
  }

  private class Params implements JsonRequest {
    String userName;
    String email;
    String password;
    String password2;
  }
}
