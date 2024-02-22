package org.mintcat.springbootexercise.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
  @Size(min = 4, max = 15)
  @NotEmpty(message = "ID는 필수항목입니다")
  private String username;

  @NotEmpty(message = "PW는 필수항목입니다")
  private String password1;

  @NotEmpty(message = "PW 확인은 필수항목입니다")
  private String password2;

  @NotEmpty(message = "Email은 필수항목입니다")
  private String email;
}
