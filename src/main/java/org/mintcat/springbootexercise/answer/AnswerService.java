package org.mintcat.springbootexercise.answer;

import lombok.RequiredArgsConstructor;
import org.mintcat.springbootexercise.question.Question;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void create(Question question, String content){
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDate.from(LocalDateTime.now()));
        answer.setQuestion(question);
        this.answerRepository.save(answer);
    }
}
