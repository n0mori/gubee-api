package com.n0mori.gubee.service;

import com.n0mori.gubee.model.Product;
import java.util.List;
import java.util.stream.Collectors;

public class ProductFilter {
  private List<Product> products;

  public ProductFilter(List<Product> products) {
    this.products = products;
  }

  public ProductFilter withStack(List<String> stack) {
    if (stack == null || stack.isEmpty()) {
      return this;
    }

    return new ProductFilter(
        products.stream()
            .filter(
                p ->
                    p.getStack().stream()
                        .anyMatch(
                            technology ->
                                stack.stream().anyMatch(s -> s.equals(technology.getName()))))
            .collect(Collectors.toList()));
  }

  public ProductFilter withMarkets(List<String> markets) {
    if (markets == null || markets.isEmpty()) {
      return this;
    }

    return new ProductFilter(
        products.stream()
            .filter(
                p ->
                    p.getTargetMarket().stream()
                        .anyMatch(
                            market -> markets.stream().anyMatch(s -> s.equals(market.getName()))))
            .collect(Collectors.toList()));
  }

  public List<Product> get() {
    return products;
  }
}
