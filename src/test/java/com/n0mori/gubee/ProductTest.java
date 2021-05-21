package com.n0mori.gubee;

import com.n0mori.gubee.model.Product;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ProductTest {
  private final String IP = "http://localhost:";

  @LocalServerPort private int port;

  @Autowired private TestRestTemplate restTemplate;

  @Test
  void getAll() {
    Product[] products = restTemplate.getForObject(IP + port + "/product", Product[].class);
    Assertions.assertNotNull(products);
    Assertions.assertEquals(3, products.length);

    products =
        restTemplate.getForObject(IP + port + "/product?markets=Loja%20Física,ERP", Product[].class);
    Assertions.assertNotNull(products);
    Assertions.assertEquals(2, products.length);
    Assertions.assertTrue(
        Arrays.stream(products)
            .allMatch(
                p ->
                    p.getTargetMarket().stream()
                        .anyMatch(
                            market -> "Loja Física".equals(market.getName()) || "ERP".equals(market.getName()))));

    products =
        restTemplate.getForObject(IP + port + "/product?stack=Java%2010,Kafka", Product[].class);
    Assertions.assertNotNull(products);
    Assertions.assertEquals(2, products.length);
    Assertions.assertTrue(
        Arrays.stream(products)
            .allMatch(
                p ->
                    p.getStack().stream()
                        .anyMatch(
                            technology -> "Java 10".equals(technology.getName()) || "Kafka".equals(technology.getName()))));


    products =
        restTemplate.getForObject(IP + port + "/product?stack=Java%2010,Kafka&markets=Loja%20Física,ERP", Product[].class);
    Assertions.assertNotNull(products);
    Assertions.assertEquals(1, products.length);
    Assertions.assertTrue(
        Arrays.stream(products)
            .allMatch(
                p ->
                    p.getStack().stream()
                        .anyMatch(
                            technology -> "Java 10".equals(technology.getName()) || "Kafka".equals(technology.getName()))
                && p.getTargetMarket().stream()
                    .anyMatch(
                        market -> "Loja Física".equals(market.getName()) || "ERP".equals(market.getName()))
            ));
  }

  @Test
  void getProduct() {
    Product product = restTemplate.getForObject(IP + port + "/product/1", Product.class);
    Assertions.assertNotNull(product);
    Assertions.assertEquals(1, product.getId());
    Assertions.assertEquals("Gubee Integrador", product.getName());

  }
}
