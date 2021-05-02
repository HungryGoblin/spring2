package ru.onlinemarket.model;

import lombok.Data;

import javax.persistence.*;

// вместо productComment
@Data
@Entity
@Table(name = "productReview")
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Product product;

    @Column(name = "rating")
    private int rating;

    @Column(name = "review", nullable = false)
    private String review;

}
