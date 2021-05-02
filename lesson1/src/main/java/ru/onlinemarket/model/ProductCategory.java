package ru.onlinemarket.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "productCategory")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

}
