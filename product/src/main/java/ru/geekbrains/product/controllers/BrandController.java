package ru.geekbrains.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.product.models.Brand;
import ru.geekbrains.product.services.BrandService;

import java.util.List;

@RestController
@RequestMapping("brands/api/v1")
public class BrandController {

    @Autowired
    BrandService brandService;

    // http://localhost:8080/products/brands/api/v1/all
    @GetMapping("/all")
    public List<Brand> getAll() {
        return brandService.getAll();
    }

    // http://localhost:8080/products/brands/api/v1/add
    @GetMapping("/add")
    public String addBrand() {
        return "brands>add";
    }

    // http://localhost:8080/products/brands/api/v1/rem
    @GetMapping("/rem")
    public String remBrand() {
        return "brands>rem";
    }

}
