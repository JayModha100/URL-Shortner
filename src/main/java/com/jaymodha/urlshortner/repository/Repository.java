package com.jaymodha.urlshortner.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<UrlShortner, String> {
    
    Optional<UrlShortner> findByShortCode(String shortCode);

    Optional<UrlShortner> findByOriginalUrl(String originalUrl);
}