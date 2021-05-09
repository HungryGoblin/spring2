package ru.geekbrains.core.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;

    private String title;

    private int price;

}
