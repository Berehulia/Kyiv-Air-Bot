package org.example.exception;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class KyivAirException extends RuntimeException {

  public KyivAirException() {
    super();
  }

}
