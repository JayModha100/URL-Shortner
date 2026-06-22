package com.jaymodha.urlshortner.controller;
import com.jaymodha.urlshortner.dto.URLRequest;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class Shortner{

    /*@GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }*/
    @PostMapping("/shorten")
    public Map <String, Object> shortenURL (@RequestBody URLRequest urlRequest) {
        return Map.of("url", urlRequest);
    }
}