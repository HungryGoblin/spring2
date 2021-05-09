package ru.geekbrains.product.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
//@EnableAspectJAutoProxy
@ComponentScan("ru.geekbrains.product")
public class AppConfig {
}

