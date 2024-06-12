package com.shortly.api.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.shortly.api.model.UrlMapping;
import com.shortly.api.repository.UrlMappingRepository;

@Service
public class UrlMappingService {

    private UrlMappingRepository urlMappingRepository;

    public UrlMappingService(UrlMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }

    public UrlMapping createShortUrl(String longUrl) {
        String shortUrl = generateShortUrl(longUrl);
        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setShortUrl(shortUrl);
        urlMapping.setLongUrl(longUrl);
        return urlMappingRepository.save(urlMapping);
    }

    public String getLongUrl(String shortUrl) {
        UrlMapping urlMapping = urlMappingRepository.findByShortUrl(shortUrl);
        if (urlMapping != null) {
            return urlMapping.getLongUrl();
        }
        return null;
    }

    public String generateShortUrl(String longUrl) {
        return Base64.getUrlEncoder().encodeToString(longUrl.getBytes(StandardCharsets.UTF_8)).substring(0, 6);
    }
}
