package ru.geekbrains.product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.core.exceptions.EntityNotFoundException;
import ru.geekbrains.product.models.Brand;
import ru.geekbrains.product.repositories.BrandRepository;

import java.util.List;


@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Brand add (Brand brand) {
        return brandRepository.saveAndFlush(brand);
    }

    public List<Brand> delete(long id) {
        brandRepository.deleteById(id);
        return getAll();
    }

    public Brand get (long id) {
        return brandRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Brand.class, id));
    }

    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

}
