package com.ak.register.vendor;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotBlank;

@Document
public class Vendor {
  @MongoId
  private String id;
  @NotBlank
  private String name;
  private String address;
  private String contact;
  @NotBlank
  private String email;
  @NotBlank
  private String password;
  private String type;
}
