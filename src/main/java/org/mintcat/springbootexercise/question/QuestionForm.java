package org.mintcat.springbootexercise.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
  // Form class는 입력값 검증뿐만 아니라, attribute binding에도 사용 가능
  @NotEmpty(message = "제목은 필수항목입니다")
  @Size(max = 200)
  private String subject;

  @NotEmpty(message = "내용은 필수항목입니다")
  private String content;
}
