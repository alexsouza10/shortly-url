package com.shortly.api.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shortly.api.service.UrlMappingService;

@RestController
@RequestMapping("/api")
public class UrlMappingController {

    private UrlMappingService urlMappingService;

    public UrlMappingController(UrlMappingService urlMappingService) {
        this.urlMappingService = urlMappingService;
    }

    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody Map<String, String> request) {
        String longUrl = request.get("longUrl");
        return urlMappingService.createShortUrl(longUrl).getLongUrl();
    }

    @GetMapping("/{shortUrl}")
    public String redirect(@PathVariable String shortUrl) {
        String longUrl = urlMappingService.getLongUrl(shortUrl);
        if(longUrl != null) {
            return "Redirecting to: " + longUrl;
        }
        return "URL not found";
    }
}
