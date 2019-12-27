package com.zkml.official_zuul.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ysyang on 2019/4/12.
 */
@Configuration
public class FileterConfig {
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        List<String> origins = new ArrayList<>();
        origins.add("*");
        config.setAllowedOrigins(origins);
        List<String> headers = new ArrayList<>();
        headers.add("*");
        config.setAllowedHeaders(headers);
        List<String> methods = new ArrayList<>();
        methods.add("OPTIONS");
        methods.add("GET");
        methods.add("POST");
        config.setAllowedMethods(methods);
        source.registerCorsConfiguration("/**", config);
        System.out.println("**************1111");
        return new CorsFilter(source);
    }
}
