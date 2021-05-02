package ru.onlinemarket.controllers;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

    @GetMapping("/index")
    public String index (
    ) {
        return ("WELCOME TO OUR SHOP!");
    }

}
