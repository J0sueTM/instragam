package com.j0suetm.instragam.desktop.models;

import java.util.*;

public class UserModel {
  public UUID id;
  public String handle;
  public String token;

  public UserModel() {}

  public UserModel(UUID id, String handle, String token) {
    this.id = id;
    this.handle = handle;
    this.token = token;
  }
}
