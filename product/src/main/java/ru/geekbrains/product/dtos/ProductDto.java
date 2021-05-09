package ru.geekbrains.product.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.product.models.Product;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private int price;

    public void productDto(Product p) {
        this.id = p.getId();
        this.name = p.getName();
        this.price = p.getPrice();
    }
}
