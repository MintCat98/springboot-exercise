package org.mintcat.springbootexercise;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.mintcat.springbootexercise.answer.Answer;
import org.mintcat.springbootexercise.answer.AnswerRepository;
import org.mintcat.springbootexercise.question.Question;
import org.mintcat.springbootexercise.question.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringbootExerciseApplicationTests {
  @Autowired private QuestionRepository questionRepository;

  @Autowired private AnswerRepository answerRepository;

  @Transactional
  @Test
  void testJpa() {
    Optional<Question> oq = this.questionRepository.findById(2);
    assertTrue(oq.isPresent());
    Question q = oq.get();

    List<Answer> answerList = q.getAnswerList();

    assertEquals(1, answerList.size());
    assertEquals("자동으로 생성됨", answerList.get(0).getContent());
  }
}
