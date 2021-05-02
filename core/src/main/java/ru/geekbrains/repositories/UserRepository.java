package ru.geekbrains.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.models.User;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);

}