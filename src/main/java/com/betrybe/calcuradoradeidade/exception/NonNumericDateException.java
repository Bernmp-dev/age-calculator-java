package com.betrybe.calcuradoradeidade.exception;

public class NonNumericDateException extends RuntimeException {
  public NonNumericDateException() { super("Date should be in numeric format."); }
}
