package com.j0suetm.instragam.desktop.models.wire;

import java.util.*;
import jakarta.validation.constraints.*;

public class UserLogInWireOutModel {
  public String handle;
  public String password;

  public UserLogInWireOutModel(String handle, String password) {
    this.handle = handle;
    this.password = password;
  }
}
