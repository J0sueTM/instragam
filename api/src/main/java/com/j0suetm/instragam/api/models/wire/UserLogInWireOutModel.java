package com.j0suetm.instragam.api.models.wire;

import java.util.*;
import jakarta.validation.constraints.*;

public class UserLogInWireOutModel {
  @NotNull
  public boolean isLoggedIn;
  public UserWireOutModel user;
  public String token;

  public UserLogInWireOutModel(
    boolean isLoggedIn,
    UserWireOutModel user,
    String token
  ) {
    this.isLoggedIn = isLoggedIn;
    this.user = user;
    this.token = token;
  }
}
