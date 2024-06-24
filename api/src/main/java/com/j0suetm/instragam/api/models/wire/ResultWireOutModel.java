package com.j0suetm.instragam.api.models.wire;

public record ResultWireOutModel(
  boolean isSuccess,
  String message,
  Object content
) {}
