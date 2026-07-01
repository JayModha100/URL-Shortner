package com.jaymodha.urlshortner.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jaymodha.urlshortner.entity.UrlShortner;
import java.util.Optional;

public interface UrlRepository extends JpaRepository<UrlShortner, String> {
    
    Optional<UrlShortner> findByOriginalUrl(String originalUrl);
}