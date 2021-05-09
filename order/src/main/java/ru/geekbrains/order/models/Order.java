package ru.geekbrains.order.models;

import lombok.Data;
import ru.geekbrains.product.models.ProductItem;
import ru.geekbrains.security.models.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "orderDate", nullable = false)
    private Date orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private User user;

    @ManyToMany
    private List<ProductItem> productItems;

}
