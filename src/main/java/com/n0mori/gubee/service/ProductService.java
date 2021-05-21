package com.n0mori.gubee.service;

import com.n0mori.gubee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

//  @Transactional
//  public insertProductBatch(List<>)

}
