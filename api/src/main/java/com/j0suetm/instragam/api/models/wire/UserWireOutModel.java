package com.j0suetm.instragam.api.models.wire;

import com.j0suetm.instragam.api.models.db.*;

import java.util.*;
import jakarta.validation.constraints.*;

public class UserWireOutModel {
  @NotNull
  public UUID id;

  @NotNull
  public String handle;

  public UserWireOutModel(UUID id, String password) {
    this.id = id;
    this.handle = handle;
  }

  public UserWireOutModel(Object obj) {
    UserDBModel userDB = new UserDBModel(obj);
    
    this.id = userDB.id;
    this.handle = userDB.handle;
  }
}
