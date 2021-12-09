package com.ak.register;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainView {
  @GetMapping
  public String viewName() {
    return "main";
  }
}
