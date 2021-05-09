package ru.geekbrains.product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.core.exceptions.EntityNotFoundException;
import ru.geekbrains.product.models.Product;
import ru.geekbrains.product.repositories.ProductRepository;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product add (Product product) {
        return productRepository.saveAndFlush(product);
    }

    public List<Product> delete(long id) {
        productRepository.deleteById(id);
        return getAll();
    }

    public Product get (long id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Product.class, id));
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

}
