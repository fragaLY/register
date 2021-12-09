package com.ak.register.qr;

import com.google.zxing.WriterException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * QRGenerationController
 * <p>
 * Controller for the QR generation page.
 * This page is used to generate a QR code for the user to scan.
 * The QR code is then used to register the user.
 * </p>
 */
@Controller
public class QRGenerationController {

  @GetMapping("/qr")
  public String qr(Model model, HttpServletRequest request) throws IOException, WriterException {
    String currentUrl = request.getRequestURL().toString();
    model.addAttribute("currenturl", request.getRequestURL().toString());
    model.addAttribute("qrcode", QRUtils.getQRCodeImageBase64(currentUrl, 300, 300));
    return "qr";
  }
}
