package ru.geekbrains.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.product.models.Product;
import ru.geekbrains.product.services.ProductService;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class ProductController {

@Autowired
ProductService productService;

    // http://localhost:8080/products/api/v1/all
    @GetMapping("/all")
    public List<Product> getAll() {
        return productService.getAll();
    }

    // http://localhost:8080/products/api/v1/add
    @GetMapping("/add")
    public String addProduct() {
        return "products>add";
    }

    // http://localhost:8080/products/api/v1/rem
    @GetMapping("/rem")
    public String remProduct() {
        return "products>rem";
    }

}

