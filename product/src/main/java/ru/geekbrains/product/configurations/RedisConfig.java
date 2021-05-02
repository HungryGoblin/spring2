package ru.geekbrains.product.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import ru.geekbrains.product.models.Product;

import java.time.Duration;

@Configuration
@EnableRedisHttpSession
public class RedisConfig {
    @Bean
    JedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName("localhost");
        redisStandaloneConfiguration.setPort(6379);
        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
        jedisClientConfiguration.connectTimeout(Duration.ofSeconds(60)); // 60s connection timeout
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration,
                jedisClientConfiguration.build());
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, Product> redisTemplateProducts() {
        RedisTemplate<String, Product> redisTemplate = new RedisTemplate<String ,Product>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
