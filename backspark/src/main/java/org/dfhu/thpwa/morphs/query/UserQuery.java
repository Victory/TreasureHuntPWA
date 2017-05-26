package org.dfhu.thpwa.morphs.query;

import org.dfhu.thpwa.morphs.UserMorph;
import org.mongodb.morphia.Datastore;

public class UserQuery extends BaseQuery {
  public UserQuery(Datastore datastore) {
    super(datastore);
  }

  public void save(UserMorph user) {
    super.save(user);
  }

  /**
   * @param userName - search term
   * @return UserMorph or null if non-found
   */
  public UserMorph getByUserName(String userName) {
    return datastore.createQuery(UserMorph.class)
      .filter("userName", userName)
      .get();
  }

  public boolean userExists(UserMorph userMorph) {
    return datastore.createQuery(UserMorph.class)
      .filter("userName", userMorph.userName)
      .get() != null;
  }
}
