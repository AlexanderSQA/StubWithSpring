package com.otus.stubwithspring;

import com.otus.stubwithspring.dto.UserDto;
import com.otus.stubwithspring.helpers.UserHelper;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GetUsers_Test {

  @Autowired
  UserHelper userHelper;

  @Autowired
  UserDto userDto;

  @Test
  @DisplayName("Get List of Users")
  void getUsersList() {
    UserDto[] userDto = userHelper.getListOfUser()
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/GetUserList.json"))
        .contentType(ContentType.JSON)
        .log().all().extract().as(UserDto[].class);

    Assertions.assertEquals("test@test.test", userDto[0].getEmail());
    Assertions.assertEquals(23, userDto[0].getAge());
  }
}
