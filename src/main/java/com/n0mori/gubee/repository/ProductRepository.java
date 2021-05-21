package com.n0mori.gubee.repository;

import com.n0mori.gubee.model.Product;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
  List<Product> findAll();
}
