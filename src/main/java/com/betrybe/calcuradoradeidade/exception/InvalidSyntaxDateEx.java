package com.betrybe.calcuradoradeidade.exception;

/** InvalidSyntaxDateEx. */
public class InvalidSyntaxDateEx extends RuntimeException {
  public InvalidSyntaxDateEx() {
    super("Invalid date format. Expected aa-mm-dd.");
  }
}
