package com.betrybe.calcuradoradeidade.service;

import com.betrybe.calcuradoradeidade.exception.FutureDateException;
import com.betrybe.calcuradoradeidade.exception.InvalidSyntaxDateEx;
import com.betrybe.calcuradoradeidade.exception.NonNumericDateException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * Aqui nessa classe devem ser implementados os métodos para atender aos requisitos do exercício,
 * sinta-se à vontade para criar métodos privados para te auxiliar nas validações.
 */
@Service
public class AgeCalculatorService {

  /** calculateAge. */
  public int calculateAge(String date) {
    isDateNumeric(date);
    validateSyntax(date);

    LocalDate localDate = LocalDate.parse(date);
    LocalDate now = LocalDate.now();
    int years = Period.between(localDate, now).getYears();

    if (years < 0) {
      throw new FutureDateException();
    }

    return years;
  }

  public int calculateAgeWithDefault(String date, int defaultAge) {
    // TODO method implementation
    return -1;
  }

  private void validateSyntax(String date) throws InvalidSyntaxDateEx {
    String[] dateBlocks = date.split("-");
    if (dateBlocks.length != 3) {
      throw new InvalidSyntaxDateEx();
    }
  }

  public static void isDateNumeric(String input) {
    input = input.replaceAll("-", "");
    Pattern pattern = Pattern.compile("[0-9]+");
    Matcher matcher = pattern.matcher(input);

    if (!matcher.matches()) {
      throw new NonNumericDateException();
    }
  }
}
