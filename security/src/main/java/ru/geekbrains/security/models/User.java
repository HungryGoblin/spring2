package ru.geekbrains.security.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "pass")
    private String pass;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private UserWallet userWallet;

}
