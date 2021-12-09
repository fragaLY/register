package com.ak.register;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class QRGenerationController {
  @GetMapping("/qr")
  public String qr(Model model, HttpServletRequest request) {
    model.addAttribute("currenturl", request.getRequestURL().toString());
    model.addAttribute("qrcode", "QR");
    return "qr";
  }
}
