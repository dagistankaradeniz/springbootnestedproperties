package com.example.test;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private Authorization auth;

    @GetMapping("/test")
    public String test() {
        return auth.getClient().toString();
    }
}

@Data
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "authorization.private")
class Authorization {
    private List<Client> client = new ArrayList<>();

    @Data
    static class Client {
        private String id;
        private Boolean available;
        private String secret;
        private String timeout;
        private List<String> redirectUris = new ArrayList<>();
    }
}
