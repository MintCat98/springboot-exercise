package org.mintcat.springbootexercise;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Question {
  @Id
  // id 속성을 key로 지정 => 각 데이터 구분, 중복 X
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // 적용된 property의 value가 자동으로 1씩 증가하며 할당됨
  // strategy는 적용 범위로, 현재 id에만 1씩 증가가 적용됨
  private Integer id;

  /*
   Column 세부 설정
  */
  @Column(length = 200)
  private String subject;

  @Column(columnDefinition = "TEXT")
  // Type, 성격 정의
  private String content;

  private LocalDateTime createDate;
}
