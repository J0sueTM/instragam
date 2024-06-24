package com.j0suetm.instragam.api.providers;

import java.util.*;
import java.util.stream.*;
import jakarta.validation.*;

public class ValidatorProvider {
  private final Validator validator = Validation
    .buildDefaultValidatorFactory()
    .getValidator();

  public <T> String[] validate(T t) {
    String[] violationMessages = null;

    Set<ConstraintViolation<T>> violations = validator.validate(t);
    if (!violations.isEmpty()) {
      violationMessages = violations
        .stream()
        .map(v -> {
          return v.getPropertyPath().toString() + " " + v.getMessage();
        })
        .collect(Collectors.toList())
        .toArray(new String[0]);
    }

    return violationMessages;
  }
}
