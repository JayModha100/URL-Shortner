package com.jaymodha.urlshortner.controller;
import com.jaymodha.urlshortner.dto.URLRequest;
import org.springframework.web.bind.annotation.*;
import com.jaymodha.urlshortner.service.UserService;
import org.springframework.web.servlet.view.RedirectView;
import java.util.Map;
import jakarta.validation.Valid;

@RestController
public class Shortner{
    private UserService userService;
    public Shortner(UserService userService)
    {
        this.userService = userService; 
    }
    
    @PostMapping("/shorten")
    public Map <String, Object> shortenURL (@Valid @RequestBody URLRequest urlRequest) {
        return Map.of("shortenedUrl", userService.shortenURL(urlRequest.getUrl()));    
    
    }
    @GetMapping("/{shortCode}")
    public RedirectView redirect(@PathVariable String shortCode) {
        String url = userService.getOriginalURL(shortCode);
        return new RedirectView(url);
    }
}