package com.dxogo.hw1.connection;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.net.URI;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HttpClientConfig {

    private static final int CONNECTION_TIMEOUT = Integer.getInteger("HTTP_CONNECT_TIMEOUT", 10_000);
    private static final int REQUEST_TIMEOUT = Integer.getInteger("HTTP_REQUEST_TIMEOUT", 30_000);
    private static final int SOCKET_TIMEOUT = Integer.getInteger("HTTP_REQUEST_TIMEOUT", REQUEST_TIMEOUT);

    // private static final String API_URL = "https://vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com/api/";
    private static final String HOST =  "vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com";
    private static final String KEY =  "28e283a580msh8faa16ce636226ep12f7f2jsndbb53c0290ab";


    @Bean
    public CloseableHttpClient httpClient() {

        List<Header> headers = new ArrayList<>();
        
        headers.add(new BasicHeader("X-RapidAPI-Host", HOST));
        headers.add(new BasicHeader("X-RapidAPI-Key", KEY));
        headers.add(new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json"));

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(REQUEST_TIMEOUT)
                .setConnectTimeout(CONNECTION_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();

        return HttpClients.custom().setDefaultRequestConfig(requestConfig)
                .setDefaultHeaders(headers)
                .build();
    }

    // public String requestTo(String url) throws IOException, InterruptedException {

    //     HttpRequest request = HttpRequest.newBuilder()
    //         .uri(URI.create(API_URL + url))
    //         .header("X-RapidAPI-Host", HOST)
    //         .header("X-RapidAPI-Key", KEY)
    //         .method("GET", HttpRequest.BodyPublishers.noBody())
    //         .build();

    //     HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    //     return response.body();
    // }

}