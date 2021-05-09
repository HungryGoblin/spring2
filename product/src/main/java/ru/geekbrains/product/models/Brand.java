package ru.geekbrains.product.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


// добавил таблицу брэндов
@Data
@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(
            mappedBy = "id",
            cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

}
