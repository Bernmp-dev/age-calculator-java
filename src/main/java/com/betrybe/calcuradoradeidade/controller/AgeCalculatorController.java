package com.betrybe.calcuradoradeidade.controller;

import com.betrybe.calcuradoradeidade.dto.DateDto;
import com.betrybe.calcuradoradeidade.service.AgeCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  /** calculateAge. */
  @GetMapping
  public ResponseEntity<DateDto> calculateAge(@RequestParam String date, String orDefaultAge) {
    int age = service.calculateAge(date);
    DateDto dateDto = new DateDto(age);

    return ResponseEntity.ok(dateDto);
  }
}
