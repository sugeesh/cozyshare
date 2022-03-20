package io.cozyshare.backend.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.awt.image.BufferedImage;

public class SharedFileReturnResource {

    @JsonProperty("sharing_url")
    private String sharingUrl;

    @JsonProperty("sharing_qr")
    private BufferedImage sharingQR;

    @JsonProperty("sharing_number")
    private int sharingNumber;

    public SharedFileReturnResource() {
    }

    public SharedFileReturnResource(String sharingUrl) {
        this.sharingUrl = sharingUrl;
    }

    public SharedFileReturnResource(String sharingUrl, BufferedImage sharingQR) {
        this.sharingUrl = sharingUrl;
        this.sharingQR = sharingQR;
    }

    public SharedFileReturnResource(String sharingUrl, BufferedImage sharingQR, int sharingNumber) {
        this.sharingUrl = sharingUrl;
        this.sharingQR = sharingQR;
        this.sharingNumber = sharingNumber;
    }

    public String getSharingUrl() {
        return sharingUrl;
    }

    public void setSharingUrl(String sharingUrl) {
        this.sharingUrl = sharingUrl;
    }


    public BufferedImage getSharingQR() {
        return sharingQR;
    }

    public void setSharingQR(BufferedImage sharingQR) {
        this.sharingQR = sharingQR;
    }

    public int getSharingNumber() {
        return sharingNumber;
    }

    public void setSharingNumber(int sharingNumber) {
        this.sharingNumber = sharingNumber;
    }

    @Override
    public String toString() {
        return "SharedFileReturnResource{" +
                "sharingUrl='" + sharingUrl + '\'' +
                ", sharingQR=" + sharingQR +
                ", sharingNumber=" + sharingNumber +
                '}';
    }
}
