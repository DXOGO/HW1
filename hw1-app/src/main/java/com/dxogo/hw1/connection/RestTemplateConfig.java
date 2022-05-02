package com.dxogo.hw1.connection;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestTemplateConfig {

    @Autowired CloseableHttpClient client;

    @Value("https://vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com/api/") 
    private String API_URL;

    @Bean
    public RestTemplate template() {
        RestTemplate template = new RestTemplate(clientHttpRequestFactory());
        template.setUriTemplateHandler(new DefaultUriBuilderFactory(API_URL));
        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return template;
    }

    @Bean
    @ConditionalOnMissingBean
    public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setHttpClient(client);
        return clientHttpRequestFactory;
    }
}