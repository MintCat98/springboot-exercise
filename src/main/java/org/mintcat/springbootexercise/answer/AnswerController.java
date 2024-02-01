package org.mintcat.springbootexercise.answer;

import lombok.RequiredArgsConstructor;
import org.mintcat.springbootexercise.question.Question;
import org.mintcat.springbootexercise.question.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("/answer")
public class AnswerController {
  private final QuestionService questionService;
  private final AnswerService answerService;

  @PostMapping("/create/{id}")
  public String createAnswer(
      Model model,
      @PathVariable("id") Integer id,
      @RequestParam(value = "content") String content) {
    // RequestParam은 사용자가 입력한 답변을 얻어오기 위함
    Question question = this.questionService.getQuestion(id);
    this.answerService.create(question, content); // 여기에서 답변 저장
    return String.format("redirect:/question/detail/%s", id);
  }
}
