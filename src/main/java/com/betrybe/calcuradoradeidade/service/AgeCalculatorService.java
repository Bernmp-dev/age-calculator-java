package com.betrybe.calcuradoradeidade.service;

import com.betrybe.calcuradoradeidade.exception.FutureDateException;
import java.time.LocalDate;
import java.time.Period;
import org.springframework.stereotype.Service;

/**
 * Aqui nessa classe devem ser implementados os métodos para atender aos requisitos do exercício,
 * sinta-se à vontade para criar métodos privados para te auxiliar nas validações.
 */
@Service
public class AgeCalculatorService {

  /** calculateAge. */
  public int calculateAge(String date) throws FutureDateException {
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
}
