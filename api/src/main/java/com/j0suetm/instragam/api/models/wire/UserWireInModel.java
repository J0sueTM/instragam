package com.j0suetm.instragam.api.models.wire;

import java.util.*;
import com.github.slugify.*;
import jakarta.validation.constraints.*;

public class UserWireInModel {
  @NotNull
  @Size(min = 3, max = 10)
  public String handle;

  @NotNull
  @Size(min = 8, max = 30)
  public String password;

  private transient final Slugify slugifier = Slugify.builder().build();

  public UserWireInModel(String handle, String password) {
    this.handle = slugifier.slugify(handle);
    this.password = Objects.requireNonNull(password, "password cannot be null");
  }
}
