package com.j0suetm.instragam.desktop.models.wire;

import java.util.*;

public class UserLogInWireInModel {
  public boolean isLoggedIn;
  public UserWireInModel user;
  public String token;

  public UserLogInWireInModel(
    boolean isLoggedIn,
    UserWireInModel user,
    String token
  ) {
    this.isLoggedIn = isLoggedIn;
    this.user = user;
    this.token = token;
  }
}
