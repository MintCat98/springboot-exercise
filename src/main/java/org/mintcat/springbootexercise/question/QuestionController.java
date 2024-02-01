package org.mintcat.springbootexercise.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/question")
public class QuestionController {
  // Service class를 통해 간접 연결
  private final QuestionService questionService;

  @GetMapping("/list")
  public String list(Model model) {
    // Model object는 java class와 template의 연결고리
    // Parameter로 Model이 들어가면 자동으로 object가 생성됨
    List<Question> questionList = this.questionService.getList();
    model.addAttribute("questionList", questionList);
    return "question_list";
  }

  @GetMapping(value = "/detail/{id}")
  public String detail(Model model, @PathVariable("id") Integer id) {
    Question question = this.questionService.getQuestion(id);
    model.addAttribute("question", question);
    return "question_detail";
  }
}
