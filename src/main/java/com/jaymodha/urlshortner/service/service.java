package com.jaymodha.urlshortner.service;
import springframework.stereotype.Service;
import com.jaymodha.urlshortner.repository.Repository;

@Service
public class UserService {
    private Repository repository;

    UserService(Repository repository)
    {
        this.repository = repository;
    }
        public String findUrl(String shortCode) {
        Optional<Url> url = urlRepository.findByShortCode(shortCode);

        return url.map(Url::getOriginalUrl)
                  .orElse("URL not found");
    }
    public void saveUrl(String shortCode, String originalUrl) {
        Url url = new Url(shortCode, originalUrl);
        urlRepository.save(url);
    
}
}