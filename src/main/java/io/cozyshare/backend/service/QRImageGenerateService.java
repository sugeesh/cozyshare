package io.cozyshare.backend.service;

import net.glxn.qrgen.javase.QRCode;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class QRImageGenerateService {

    public BufferedImage generateQRCodeImage(String barcodeUrl) throws Exception {
        ByteArrayOutputStream stream = QRCode
                .from(barcodeUrl)
                .withSize(250, 250)
                .stream();
        ByteArrayInputStream bis = new ByteArrayInputStream(stream.toByteArray());
        return ImageIO.read(bis);
    }

}
