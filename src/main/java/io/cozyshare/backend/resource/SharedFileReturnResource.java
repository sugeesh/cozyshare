package io.cozyshare.backend.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SharedFileReturnResource {

    @JsonProperty("sharing_url")
    private String sharingUrl;

    public SharedFileReturnResource() {
    }

    public SharedFileReturnResource(String sharingUrl) {
        this.sharingUrl = sharingUrl;
    }

    public String getSharingUrl() {
        return sharingUrl;
    }

    public void setSharingUrl(String sharingUrl) {
        this.sharingUrl = sharingUrl;
    }

    @Override
    public String toString() {
        return "SharedFileReturnResource{" +
                "sharingUrl='" + sharingUrl + '\'' +
                '}';
    }
}
