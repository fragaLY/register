package com.ak.register.qr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.experimental.UtilityClass;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Base64;

@UtilityClass
public class QRUtils {

  /**
   * Generates QR code image for the given text and saves it to the given path.
   *
   * @param text
   * @param width
   * @param height
   * @param filePath
   * @throws WriterException
   * @throws IOException
   */
  public static void generateQRCodeImage(String text, int width, int height, String filePath)
    throws WriterException, IOException {
    QRCodeWriter qrCodeWriter = new QRCodeWriter();
    BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

    Path path = FileSystems.getDefault().getPath(filePath);
    MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
  }

  /**
   * Generates QR code image for the given text and returns it as a byte array.
   *
   * @param text
   * @param width
   * @param height
   * @return
   * @throws WriterException
   * @throws IOException
   */
  public static byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
    QRCodeWriter qrCodeWriter = new QRCodeWriter();
    BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

    ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
    MatrixToImageConfig config = new MatrixToImageConfig(MatrixToImageConfig.BLACK, MatrixToImageConfig.WHITE);

    MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream, config);
    return pngOutputStream.toByteArray();
  }

  public static String getQRCodeImageBase64(String text, int width, int height) throws WriterException, IOException {
    return Base64.getEncoder().encodeToString(getQRCodeImage(text, width, height));
  }
}
