package ru.onlinemarket.model;

import lombok.Data;

import javax.persistence.*;

// вместо UserCashBack
// не уверен что данная таблица нужна, можно поля добавить в user
@Data
@Entity
@Table(name = "userWallet")
public class UserWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "balance")
    private long balance;

    @OneToOne(mappedBy = "id")
    private User user;

}
