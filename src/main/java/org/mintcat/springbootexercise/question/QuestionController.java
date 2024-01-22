package org.mintcat.springbootexercise.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuestionController {
  private final QuestionRepository questionRepository;

  @GetMapping("/question/list")
  public String list(Model model) {
    // Model object는 java class와 template의 연결고리
    // Parameter로 Model이 들어가면 자동으로 object가 생성됨
    List<Question> questionList = this.questionRepository.findAll();
    model.addAttribute("questionList", questionList);
    return "question_list";
  }
}
