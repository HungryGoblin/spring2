package ru.geekbrains.product.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.product.models.Product;

@Data
@NoArgsConstructor
public class BrandDto {
    private Long id;
    private String name;

    public void brandDto(Product p) {
        this.id = p.getId();
        this.name = p.getName();
    }
}
