package com.example.SehirRehberiAPI;


import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableJpaAuditing
public class SehirRehberiApiApplication {

    @Value("${cloudinary.cloudname}")
    private String cloudName;

    @Value("${cloudinary.apikey}")
    private String apiKey;

    @Value("${cloudinary.apisecret}")
    private String apiSecret;

    public static void main(String[] args) {
        SpringApplication.run(SehirRehberiApiApplication.class, args);
    }

    @Bean
    public Cloudinary cloudinaryConfig() {
        Cloudinary cloudinary;
        Map config = new HashMap();
        config.put("cloud_name", cloudName);
        config.put("api_key", apiKey);
        config.put("api_secret", apiSecret);
        cloudinary = new Cloudinary(config);
        return cloudinary;
    }
}
