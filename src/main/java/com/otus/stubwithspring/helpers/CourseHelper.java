package com.otus.stubwithspring.helpers;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseHelper extends AbsHelper {
  private final RequestSpecification spec;

  @Autowired
  public CourseHelper() {
    spec = given()
        .baseUri(BASE_URI)
        .basePath("/course/get/")
        .contentType(ContentType.JSON);
  }

  public ValidatableResponse getJavaCourse() {
    return given(spec)
        .log().all()
        .when()
        .get("java")
        .then();
  }

  public ValidatableResponse geListOfCourse() {
    return given(spec)
        .log().all()
        .when()
        .get("all")
        .then();
  }

}
