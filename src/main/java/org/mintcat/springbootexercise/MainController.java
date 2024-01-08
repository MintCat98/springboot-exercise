package org.mintcat.springbootexercise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class MainController {
  @GetMapping("/sbb")
  @ResponseBody
  public String index() {
    return "index";
  }
}
