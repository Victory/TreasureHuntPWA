package org.dfhu.thpwa;

import org.dfhu.thpwa.auth.UserGroup;

import java.util.HashSet;
import java.util.Set;

public class UserInfo {
  public boolean isLoggedIn = false;
  public String userName = "Guest";
  public Set<UserGroup> groups = new HashSet<>();
}
