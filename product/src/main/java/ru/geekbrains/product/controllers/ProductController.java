package ru.geekbrains.product.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")

public class ProductController {

    // http://localhost:8080/shop/api/v1/index
    @GetMapping("/index")
    public String index() {
        return "HELLO!";
    }

}

