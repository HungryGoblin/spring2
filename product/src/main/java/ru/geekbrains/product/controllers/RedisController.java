package ru.geekbrains.product.controllers;

/*
FOR TEST USE ONLY!
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.product.models.Product;
import ru.geekbrains.product.services.RedisService;

@RestController
@RequestMapping("/api/v1/")

public class RedisController {

    @Autowired
    RedisService redisService;

    // http://localhost:8080/shop/api/v1/redis/put
    @GetMapping("/redis/put")
    public String put() {
        redisService.putProduct(new Product());
        return redisService.getAllProducts().toString();
    }

}

