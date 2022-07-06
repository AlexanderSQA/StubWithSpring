package com.otus.stubwithspring.controllers;

import com.otus.stubwithspring.dto.ScoreDto;
import com.otus.stubwithspring.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user/get")
public class UserController {

  private final UserDto userDto;
  private final ScoreDto scoreDto;

  @Autowired
  public UserController(UserDto userDto, ScoreDto scoreDto) {
    this.userDto = userDto;
    this.scoreDto = scoreDto;
  }

  @GetMapping(value = "/all")
  public List<UserDto> getAllUsers() {
    List<UserDto> userList = new ArrayList<>();
    userList.add(new UserDto("Test User", "QA", "test@test.test", 23));
    return userList;
  }

  @GetMapping(value = "/{id}")
  public ScoreDto getUserScore(@PathVariable("id") int id) {
    return new ScoreDto("Test User", "78");
  }

}
