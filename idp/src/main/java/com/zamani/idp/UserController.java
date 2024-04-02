package com.zamani.idp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/idp/api/v1")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final RestTemplate restTemplate;
  //private final RestClient restClient;

    @PostMapping(value = "/token")
    public PasswordGrantTypeOutputDto token(PasswordGrantTypeInputDto input) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        Map<String, Object> requestBody = new LinkedHashMap<>();
        requestBody.put("grant_type", input.getGrantType());
        requestBody.put("client_id", input.getClientId());
        requestBody.put("username", input.getUsername());
        requestBody.put("password", input.getPassword());

        HttpEntity request = new HttpEntity<>(requestBody, requestHeaders);

        return restTemplate.postForObject("http://localhost:8080/realms/eshop-realm/protocol/openid-connect/token",
                request, PasswordGrantTypeOutputDto.class);

        /*return restClient
                .post()
                .uri("http://localhost:8080/realms/eshop-realm/protocol/openid-connect/token")
                .body(request)
                .retrieve()
                .toEntity(PasswordGrantTypeOutputDto.class);*/
    }
}
