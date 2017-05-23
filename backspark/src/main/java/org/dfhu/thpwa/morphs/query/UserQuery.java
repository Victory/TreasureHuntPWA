package org.dfhu.thpwa.morphs.query;

import org.dfhu.thpwa.morphs.UserMorph;
import org.mongodb.morphia.Datastore;

public class UserQuery extends BaseQuery {
  public UserQuery(Datastore datastore) {
    super(datastore);
  }

  public boolean userExists(UserMorph userMorph) {
    return datastore.createQuery(UserMorph.class)
      .filter("userName", userMorph.userName)
      .get() != null;
  }
}
