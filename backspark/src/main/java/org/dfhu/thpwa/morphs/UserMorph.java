package org.dfhu.thpwa.morphs;

import org.bson.types.ObjectId;
import org.dfhu.thpwa.auth.UserGroup;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexed;

import java.util.Set;

@Entity("users")
public class UserMorph {
  @Id
  public ObjectId id;
  @Indexed(options = @IndexOptions(unique = true))
  public String userName;
  public String email;
  public Set<UserGroup> groups;
  public String password;
}
