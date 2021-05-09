package ru.geekbrains.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.auth.dto.SignOutRequestDto;
import ru.geekbrains.auth.entities.User;
import ru.geekbrains.auth.services.UserService;
import ru.geekbrains.core.interfaces.ITokenService;
import ru.geekbrains.core.model.UserInfo;
import ru.geekbrains.core.model.dto.AuthRequestDto;
import ru.geekbrains.core.model.dto.AuthResponseDto;
import ru.geekbrains.core.model.dto.SignUpRequestDto;


@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private ITokenService tokenService;

    @PostMapping("/signup")
    public String signUp(@RequestBody SignUpRequestDto signUpRequest) {
        User user = new User();
        user.setPassword(signUpRequest.getPassword());
        user.setLogin(signUpRequest.getLogin());
        userService.saveUser(user);
        return "OK";
    }

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody AuthRequestDto request) {
        User user = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());

        UserInfo userInfo = UserInfo.builder()
                .userId(user.getId())
                .userEmail(user.getLogin())
                .role(user.getRole().getName())
                .build();
        String token = tokenService.generateToken(userInfo);
        return new AuthResponseDto(token);
    }


    @PostMapping("/logout")
    public String logout(@RequestBody SignOutRequestDto request) {
        userService.logout(request.getToken());
        return ("See you later!");
    }


    @GetMapping("/check")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String check() {
        return "OK!";
    }

}