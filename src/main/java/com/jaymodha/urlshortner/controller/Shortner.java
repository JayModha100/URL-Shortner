package com.jaymodha.urlshortner.controller;
import com.jaymodha.urlshortner.dto.URLRequest;
import org.springframework.web.bind.annotation.*;
import com.jaymodha.urlshortner.service.UserService;
import java.util.Map;

@RestController
public class Shortner{
    private UserService userService;
    Shortner(UserService userService)
    {
        this.userService = userService; 
    }
    
    @PostMapping("/shorten")
    public Map <String, Object> shortenURL (@RequestBody URLRequest urlRequest) {
        return Map.of("shortenedUrl", userService.shortenURL(urlRequest.getUrl()));
        
        }
}