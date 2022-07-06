package com.otus.stubwithspring.controllers;

import com.otus.stubwithspring.dto.CourseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/course/get")
public class CourseController {

  private final CourseDto courseDto;


  public CourseController(CourseDto courseDto) {
    this.courseDto = courseDto;
  }

  @GetMapping(value = "/java")
  public CourseDto getCourse() {
    return new CourseDto("QA java", 15000);
  }

  @GetMapping(value = "/all")
  public List<CourseDto> getAllCourses() {
    List<CourseDto> courseList = new ArrayList<>();
    courseList.add(new CourseDto("QA java", 15000));
    courseList.add(new CourseDto("Java", 12000));
    return courseList;
  }

}
