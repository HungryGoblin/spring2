package ru.geekbrains.order.controllers;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class OrderController {
//
//    @RequestMapping("/")
//    public @ResponseBody String greeting() {
//        return "Hello, World";
//    }
//
//}

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class OrderController {

    // http://localhost:8181/orders/api/v1/index
    @GetMapping("/index")
    public String index() {
        return "HELLO!";
    }

    // http://localhost:8181/orders/api/v1/orders
    @GetMapping("/orders")
    public String orders() {
        return "orders";
    }

}
