package org.student.guestblog.controller;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class HelloController {

  @GetMapping("/hello")
  public ResponseEntity<JsonObject> handleHello() {
    log.info("Hello, logger!");
    JsonObject answer = new JsonObject();
    answer.addProperty("greeting", "hello!");

    return new ResponseEntity<>(answer, HttpStatus.OK);
  }
}
