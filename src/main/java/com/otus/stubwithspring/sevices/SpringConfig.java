package com.otus.stubwithspring.sevices;

import com.otus.stubwithspring.dto.CourseDto;
import com.otus.stubwithspring.dto.ScoreDto;
import com.otus.stubwithspring.dto.UserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

  @Bean
  public UserDto getUser() {
    return new UserDto();
  }

  @Bean
  public ScoreDto getUserScore() {
    return new ScoreDto();
  }

  @Bean
  public CourseDto getCourse() {
    return new CourseDto();
  }
}
