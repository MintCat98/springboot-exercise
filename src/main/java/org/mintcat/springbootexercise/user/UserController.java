package org.mintcat.springbootexercise.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
  private final UserService userService;

  @GetMapping("/signup")
  public String signup(UserCreateForm userCreateForm) {
    return "signup_form";
  }

  @PostMapping("/signup")
  public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "signup_form";
    }

    // PW와 PW확인 일치 검증
    if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
      bindingResult.rejectValue("password2", "passwordInCorrect", "PW 확인이 일치하지 않습니다");
      return "signup_form";
    }

    // 중복 검증
    try {
      userService.create(
          userCreateForm.getUsername(), userCreateForm.getEmail(), userCreateForm.getPassword1());
    } catch (DataIntegrityViolationException e) {
      e.printStackTrace();
      bindingResult.reject("signupFailed", "중복된 ID입니다.");
      return "signup_form";
    } catch (Exception e) {
      e.printStackTrace();
      bindingResult.reject("signupFailed", e.getMessage());
      return "signup_form";
    }

    return "redirect:/";
  }
}
