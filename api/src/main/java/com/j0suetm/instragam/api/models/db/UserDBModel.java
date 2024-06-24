package com.j0suetm.instragam.api.models.db;

import com.j0suetm.instragam.api.models.wire.*;

import java.util.*;

public class UserDBModel {
  public UUID id;
  public String handle;
  public String passwordHash;

  public UserDBModel(UUID id, String handle, String passwordHash) {
    this.id = id;
    this.handle = handle;
    this.passwordHash = passwordHash;
  }

  public UserDBModel(Object obj)
    throws IllegalArgumentException
  {
    if (!(obj instanceof UserDBModel)) {
      throw new IllegalArgumentException("expected instance of UserDBModel");
    }

    UserDBModel userDB = (UserDBModel)obj;
    this.id = userDB.id;
    this.handle = userDB.handle;
    this.passwordHash = userDB.passwordHash;
  }

  public UserDBModel(UserWireInModel userIn, String passwordHash) {
    this.id = UUID.randomUUID();
    this.handle = userIn.handle;
    this.passwordHash = passwordHash;
  }
}
