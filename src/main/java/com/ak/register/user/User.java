package com.ak.register.user;

import com.mongodb.lang.Nullable;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotEmpty;

/**
 * Entity class for User
 */
@Document
public class User {
  @MongoId
  private String id;
  @NotEmpty
  private String firstName;
  @NotEmpty
  private String lastName;
  @Nullable
  private String email;
}
