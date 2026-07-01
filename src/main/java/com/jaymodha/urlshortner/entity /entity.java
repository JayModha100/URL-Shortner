package com.jaymodha.urlshortner.entity;
import jakarta.persistence.Entity; 
import jakarta.persistence.Id;
import jakarta.persistence.Table; 

@Entity
@Table(name = "urlshortner")
public class UrlShortner {
    @Id
    private String shortCode;
    private String originalUrl;

    public UrlShortner() {
    }
    public UrlShortner(String shortCode, String originalUrl) {
        this.shortCode = shortCode;
        this.originalUrl = originalUrl;
    }
    public String getShortCode() {
        return shortCode;
    }
    public void setShortCode(String shortCode) {
        this.shortCode = shortCode; 
    }
    public String getOriginalUrl() {
        return originalUrl;
    }
    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}