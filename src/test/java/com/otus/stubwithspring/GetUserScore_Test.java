package com.otus.stubwithspring;

import com.otus.stubwithspring.dto.ScoreDto;
import com.otus.stubwithspring.helpers.UserHelper;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GetUserScore_Test {

  @Autowired
  private ScoreDto scoreDto;

  @Autowired
  private UserHelper userHelper;

  @Test
  @DisplayName("Get score of user")
  void getUserScore() {
    scoreDto = userHelper.getUserScore("1")
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/GetScore.json"))
        .contentType(ContentType.JSON)
        .log().all().extract().as(ScoreDto.class);

    Assertions.assertEquals("Test User", scoreDto.getName());
    Assertions.assertEquals("78", scoreDto.getScore());
  }

}
