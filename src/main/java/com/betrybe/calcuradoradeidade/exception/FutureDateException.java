package com.betrybe.calcuradoradeidade.exception;

/** FutureDateException. */
public class FutureDateException extends RuntimeException {
  public FutureDateException() {
    super("This is a future date.");
  }
}