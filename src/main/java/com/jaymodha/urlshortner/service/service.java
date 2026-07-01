package com.jaymodha.urlshortner.service;
import org.springframework.stereotype.Service;
import com.jaymodha.urlshortner.repository.UrlRepository;
import java.util.Optional;
import com.jaymodha.urlshortner.entity.UrlShortner;
import java.util.UUID;

@Service
public class UserService {
    private UrlRepository repository;

    public UserService(UrlRepository repository)
    {
        this.repository = repository;
    }
    public String shortenURL(String url){
        Optional<UrlShortner> existing= repository.findByOriginalUrl(url);

        if(existing.isPresent()) {

            return "http://localhost:8080/" +    existing.get().getShortCode();
        }
        
        String shortCode = generateCode();

        // 3. Save mapping in database

        UrlShortner urlEntity = 
                new UrlShortner(shortCode, url);


        repository.save(urlEntity);



        // 4. Return shortcode
        return "http://localhost:8080/"+ shortCode;
    }

    private String generateCode(){
        String code;

       do{ code = UUID.randomUUID()
                .toString()
                .substring(0,6);
        }while(repository.existsById(code));
        return code;
}
    public String getOriginalURL(String shortCode) {
        Optional<UrlShortner> urlEntity = repository.findById(shortCode);
        if(urlEntity.isPresent()) {
            return urlEntity.get().getOriginalUrl();
        }
        throw new RuntimeException("Short URL not found");

    }
           
}
