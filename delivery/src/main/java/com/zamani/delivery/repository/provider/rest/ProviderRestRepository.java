package com.zamani.delivery.repository.provider.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zamani.delivery.entity.provider.Provider;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.UUID;

@Repository
public class ProviderRestRepository implements IProviderRestRepository<Provider, UUID> {
    private final RestTemplate restTemplate;

    public ProviderRestRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public JsonNode findAll() throws IOException {
        ResponseEntity responseEntity = restTemplate.exchange("http://api.podro.ir/provider", HttpMethod.GET, null, Provider.class);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(Objects.requireNonNull(responseEntity.getBody()).toString().getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public JsonNode saveAndFlush(Provider provider) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("ACCEPT", "APPLICATION_JSON");
        headers.add("CONTENT_TYPE", "URL_ENCODED_CONTENT_TYPE");

        HttpEntity request = new HttpEntity(provider, headers);
        String response = restTemplate.postForObject("http://api.podro.ir/provider", request, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(Objects.requireNonNull(response.getBytes(StandardCharsets.UTF_8)));
    }
}
