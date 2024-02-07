package org.mintcat.springbootexercise;

import org.junit.jupiter.api.Test;
import org.mintcat.springbootexercise.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootExerciseApplicationTests {
  @Autowired private QuestionService questionService;

  @Test
  void testJpa() {
    for (int i = 0; i < 300; i++) {
      String subject = String.format("Large Test Data: [%03d]", i);
      String content = "Test";
      this.questionService.create(subject, content);
    }
  }
}
