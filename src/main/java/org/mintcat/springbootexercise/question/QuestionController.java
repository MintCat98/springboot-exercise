package org.mintcat.springbootexercise.question;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.mintcat.springbootexercise.answer.AnswerForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("/detail/{id}")
  public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
    Question question = this.questionService.getQuestion(id);
    model.addAttribute("question", question);
    return "question_detail";
  }

  @GetMapping("/create")
  public String questionCreate(QuestionForm questionForm) {
    return "question_form";
  }

  // Overloaded
  @PostMapping("/create")
  public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "question_form";
    }
    this.questionService.create(questionForm.getSubject(), questionForm.getContent());
    // 답변 저장 시 질문 목록으로 이동
    return "redirect:/question/list";
  }
}
