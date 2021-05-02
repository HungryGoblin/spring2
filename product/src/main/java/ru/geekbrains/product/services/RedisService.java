package ru.geekbrains.product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import ru.geekbrains.product.models.Product;

import java.util.Map;

@Service
@ComponentScan
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplateProducts;
    private static final String HASH_CODE = "PRODUCT";

    HashOperations productsCache = redisTemplateProducts.opsForHash();

    public void putProduct (Product product) {
        productsCache.put(HASH_CODE, product.getId().toString(), product);
    }

    public Product getProduct (Long productId) {
        return (Product) productsCache.get(HASH_CODE, productId.toString());
    }

    public void delProduct (Long productId) {
        productsCache.delete(HASH_CODE, productId.toString());
    }

    public Map<Object, Object> getAllProducts () {
        return productsCache.entries(HASH_CODE);
    }

}
