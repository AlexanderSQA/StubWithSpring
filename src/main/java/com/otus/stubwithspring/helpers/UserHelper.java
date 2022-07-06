package com.otus.stubwithspring.helpers;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserHelper extends AbsHelper {
  private final RequestSpecification spec;

  @Autowired
  public UserHelper() {
    spec = given()
        .baseUri(BASE_URI)
        .basePath("/user/get/")
        .contentType(ContentType.JSON);
  }

  public ValidatableResponse getListOfUser() {
    return given(spec)
        .log().all()
        .when()
        .get("all")
        .then();
  }

  public ValidatableResponse getUserScore(String id) {
    return given(spec)
        .log().all()
        .when()
        .get(id)
        .then();
  }
}
