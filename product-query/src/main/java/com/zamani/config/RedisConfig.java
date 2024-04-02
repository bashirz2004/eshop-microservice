package com.zamani.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
@RequiredArgsConstructor
public class RedisConfig {
    private final Environment environment;

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private String port;

    /*@Value("${redis.username}")
    private String username;

    @Value("${redis.password}")
    private String password;*/

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration standAloneConfig = new RedisStandaloneConfiguration();
        standAloneConfig.setHostName(host);
        standAloneConfig.setPort(Integer.parseInt(port));
        //standAloneConfig.setUsername(username);
        //standAloneConfig.setPassword(password);
        return new LettuceConnectionFactory(standAloneConfig);
    }
}
