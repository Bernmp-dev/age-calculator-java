package com.betrybe.calcuradoradeidade.controller;

import com.betrybe.calcuradoradeidade.dto.DateDto;
import com.betrybe.calcuradoradeidade.service.AgeCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/** AgeCalculatorController. */
@RestController
@RequestMapping("/calculateAge")
public class AgeCalculatorController implements AgeCalculatorControllerInterface {

  private final AgeCalculatorService service;

  @Autowired
  public AgeCalculatorController(AgeCalculatorService service) {
    this.service = service;
  }

  /**
   * calculateAge.
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public DateDto calculateAge(String date, String orDefaultAge) {
    if (orDefaultAge == null) {
      return new DateDto(service.calculateAge(date));
    }

    return new DateDto(
        service.calculateAgeWithDefault(
        date, Integer.parseInt(orDefaultAge)
        ));
  }
}
