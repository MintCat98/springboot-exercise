package org.mintcat.springbootexercise.question;

import lombok.RequiredArgsConstructor;
import org.mintcat.springbootexercise.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {
  private final QuestionRepository questionRepository;

  public List<Question> getList() {
    return this.questionRepository.findAll();
  }

  public Question getQuestion(Integer id) {
    Optional<Question> question = this.questionRepository.findById(id);
    if (question.isPresent()){
      return question.get();
    } else{
      throw new DataNotFoundException("question is not found");
    }
  }
}
