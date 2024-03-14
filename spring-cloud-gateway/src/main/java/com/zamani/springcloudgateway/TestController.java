package com.zamani.springcloudgateway;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    @GetMapping("/test")
    @Tag(name = "test")
    public Mono<TestDto> getTestDto(final @RequestParam String name,
                                    final ServerWebExchange exchange) {
        TestDto testDto = new TestDto();
        testDto.setName(name);
        testDto.setAge(0);
        testDto.setName("Welcome " + name);
        return Mono.just(testDto);
    }

    @PostMapping("/test")
    @Tag(name = "test")
    public Mono<TestDto> postTestDto(@Valid @RequestBody final TestDto testDto,
                                     final ServerWebExchange exchange) {
        return Mono.just(testDto);
    }

}
