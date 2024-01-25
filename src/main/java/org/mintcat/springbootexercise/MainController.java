package org.mintcat.springbootexercise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
  @GetMapping("/sbb")
  public void index() {
    System.out.println("index");
  }

  /* Root URL */
  @GetMapping("/")
  public String root(){
    // 메인 페이지로 질문목록을 설정
    return "redirect:/question/list";
  }
}
