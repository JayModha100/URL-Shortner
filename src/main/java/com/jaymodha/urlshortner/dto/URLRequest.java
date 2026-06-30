package com.jaymodha.urlshortner.dto;
import jakarta.validation.constraints.NotNull;
public class URLRequest{
    @NotNull
    private String url;

    public URLRequest() {
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }
}