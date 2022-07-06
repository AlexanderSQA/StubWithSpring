package com.otus.stubwithspring;

import com.otus.stubwithspring.dto.CourseDto;
import com.otus.stubwithspring.helpers.CourseHelper;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GetCourse_Test {

  @Autowired
  CourseDto courseDto;
  @Autowired
  CourseHelper courseHelper;

  @Test
  @DisplayName("Get Java Course only")
  void getJavaCourse() {
    courseDto = courseHelper.getJavaCourse()
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/GetCourse.json"))
        .contentType(ContentType.JSON)
        .log().all().extract().as(CourseDto.class);

    Assertions.assertEquals("QA java", courseDto.getCourseName());
    Assertions.assertEquals(15000, courseDto.getPrice());
  }

  @Test
  @DisplayName("Get list of courses")
  void getCourseList() {
    CourseDto[] courseDto = courseHelper.geListOfCourse()
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/GetCourseList.json"))
        .contentType(ContentType.JSON)
        .log().all().extract().as(CourseDto[].class);
    Assertions.assertEquals("QA java", courseDto[0].getCourseName());
    Assertions.assertEquals(15000, courseDto[0].getPrice());
    Assertions.assertEquals("Java", courseDto[1].getCourseName());
    Assertions.assertEquals(12000, courseDto[1].getPrice());

  }

}
