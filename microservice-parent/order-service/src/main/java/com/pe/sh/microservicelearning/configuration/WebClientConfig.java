package com.pe.sh.microservicelearning.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author shmen
 */
@Configuration
public class WebClientConfig {
    
    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }
    
}
