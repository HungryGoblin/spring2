package ru.onlinemarket.model;

import jdk.jfr.Category;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private ProductCategory productCategory;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany (
            mappedBy="id",
            cascade=CascadeType.ALL,
            fetch=FetchType.LAZY,
            orphanRemoval=true)
    private List<ProductReview> productReviews = new ArrayList<>();;

}
