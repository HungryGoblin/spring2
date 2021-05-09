package ru.geekbrains.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.geekbrains.product.models.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    @Query("select b from Brand b where b.name = :name")
    Brand findByName(@Param("name") String name);

}
