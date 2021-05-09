package ru.geekbrains.core.model.dto;

import lombok.Data;

@Data
public class SignUpRequestDto {

    private String login;

    private String password;

}