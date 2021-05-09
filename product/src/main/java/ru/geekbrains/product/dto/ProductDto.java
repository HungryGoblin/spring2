package ru.geekbrains.product.dto;

import lombok.Data;
import ru.geekbrains.product.models.Product;

@Data
public class ProductDto {
    private Long id;
    private String title;
    private int price;

    public ProductDto(Product p) {
        this.id = p.getId();
        this.title = p.getTitle();
        this.price = p.getPrice();
    }


}
