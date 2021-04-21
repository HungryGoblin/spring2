package ru.geekbrains.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.happy.market.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);

}