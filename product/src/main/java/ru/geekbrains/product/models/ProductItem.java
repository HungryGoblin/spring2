package ru.geekbrains.product.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "productItem")
public class ProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Product product;

    @Column(name = "productStatusId", nullable = false)
    private long productStatusId;

    @Column(name = "description")
    private String description;

}
