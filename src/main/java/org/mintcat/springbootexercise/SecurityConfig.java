package org.mintcat.springbootexercise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
            (authorizeHttpRequest) ->
                authorizeHttpRequest.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
        .csrf((csrf) -> csrf.ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")))
        .headers(
            (headers) ->
                headers.addHeaderWriter(
                    new XFrameOptionsHeaderWriter(
                        XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)));
    // csrf    => h2-console은 토큰이 없어서 접속이 안 되므로 예외 처리를 해줌
    // headers => h2-console 화면이 깨지는 현상 방지
    return http.build();
  }

  @Bean
  // 이렇게 Bean으로 관리해야 인코딩 방식을 일괄 변경할 수 있음
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
