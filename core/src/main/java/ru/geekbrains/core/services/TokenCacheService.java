package ru.geekbrains.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TokenCacheService {


    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate redisTemplateTokens;

    @Autowired JWTTokenService tokenService;

    private static final String HASH_CODE = "JWWTTOKEN";

    HashOperations tokensCache = redisTemplateTokens.opsForHash();

    public void putToken (String token) {
        // token, userInfo
        tokensCache.put(HASH_CODE, token, tokenService.parseToken(token));
    }

    public String getToken (Long tokenId) {
        return (String) tokensCache.get(HASH_CODE, tokenId.toString());
    }

    public void delToken (Long tokenId) {
        tokensCache.delete(HASH_CODE, tokenId.toString());
    }

    public Map<Object, Object> getAllTokens () {
        return tokensCache.entries(HASH_CODE);
    }

}
