package org.mintcat.springbootexercise.answer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.mintcat.springbootexercise.question.Question;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Answer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(columnDefinition = "TEXT")
  private String content;

  private LocalDate createDate;

  @ManyToOne private Question question;
}
