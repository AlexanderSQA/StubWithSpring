package com.otus.stubwithspring.dto;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
  private String name;
  private String course;
  private String email;
  private int age;
}
