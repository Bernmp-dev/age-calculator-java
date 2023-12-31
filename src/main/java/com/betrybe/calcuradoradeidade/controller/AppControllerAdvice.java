package com.betrybe.calcuradoradeidade.controller;

import com.betrybe.calcuradoradeidade.dto.ErrorMessageDto;
import com.betrybe.calcuradoradeidade.exception.FutureDateException;
import com.betrybe.calcuradoradeidade.exception.InvalidSyntaxDateEx;
import com.betrybe.calcuradoradeidade.exception.NonNumericDateException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/** AppControllerAdvice. */
@RestControllerAdvice
public class AppControllerAdvice {

  @ExceptionHandler(FutureDateException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  public ErrorMessageDto handleFutureDateEx(RuntimeException exception) {
    return new ErrorMessageDto(exception.getMessage());
  }

  @ExceptionHandler({InvalidSyntaxDateEx.class, NonNumericDateException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorMessageDto handleBadRequest(RuntimeException exception) {
    return new ErrorMessageDto(exception.getMessage());
  }
}