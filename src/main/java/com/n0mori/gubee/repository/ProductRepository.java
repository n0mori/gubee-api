package com.n0mori.gubee.repository;

import com.n0mori.gubee.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
