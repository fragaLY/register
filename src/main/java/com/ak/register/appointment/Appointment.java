package com.ak.register.appointment;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Document
public class Appointment {
  @MongoId
  private String id;
  private LocalDateTime created = LocalDateTime.now();
  @NotNull
  private Integer queueNumber;
}
