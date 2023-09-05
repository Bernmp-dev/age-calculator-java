package com.betrybe.calcuradoradeidade.exception;

/** NonNumericDateException. */
public class NonNumericDateException extends RuntimeException {
  public NonNumericDateException() {
    super("Date should be in numeric format.");
  }
}
