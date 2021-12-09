package com.ak.register;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QRGenerationController {
  @GetMapping("/qr")
  public String qr(ModelAndView modelAndView) {
    modelAndView.addObject("qrcode", "QR");
    return "qr";
  }
}
