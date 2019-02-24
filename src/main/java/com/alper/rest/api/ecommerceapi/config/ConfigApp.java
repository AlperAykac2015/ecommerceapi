package com.alper.rest.api.ecommerceapi.config;

import com.alper.rest.api.ecommerceapi.controller.ProductController;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigApp {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Do any additional configuration here
        return builder.build();
    }



}
