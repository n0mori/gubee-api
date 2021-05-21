package com.n0mori.gubee.controller;

import com.n0mori.gubee.model.Product;
import com.n0mori.gubee.repository.ProductRepository;
import com.n0mori.gubee.service.ProductFilter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
  @Autowired private ProductRepository productRepository;

  @GetMapping("")
  public List<Product> getProducts(
      @RequestParam(required = false) List<String> markets,
      @RequestParam(required = false) List<String> stack) {
    return new ProductFilter(productRepository.findAll())
        .withStack(stack)
        .withMarkets(markets)
        .get();
  }

  @GetMapping("/{id}")
  public Product getProduct(@PathVariable("id") Integer id) {
    return productRepository
        .findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }
}
