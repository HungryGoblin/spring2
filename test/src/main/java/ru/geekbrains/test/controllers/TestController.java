package ru.geekbrains.test.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class TestController {

    // http://localhost:8080/test/api/v1/index
    @GetMapping("/index")
    public String index() {
        return "HELLO!";
    }

    // http://localhost:8080/test/api/v1/all
    @GetMapping("/all")
    public String alltest() {
        return "test";
    }

    // http://localhost:8080/test/api/v1/add
    @GetMapping("/add")
    public String addProduct() {
        return "test>add";
    }

    // http://localhost:8080/test/api/v1/rem
    @GetMapping("/rem")
    public String remProduct() {
        return "test>rem";
    }

}

