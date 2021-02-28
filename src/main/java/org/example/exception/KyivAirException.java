package org.example.exception;

public class KyivAirException extends RuntimeException {

  public KyivAirException() {
    super();
  }

  public KyivAirException(Exception exception) {
    super(exception);
  }

}
