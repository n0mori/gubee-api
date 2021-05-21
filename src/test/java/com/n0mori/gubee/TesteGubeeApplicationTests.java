package com.n0mori.gubee;

import com.n0mori.gubee.controller.MarketController;
import com.n0mori.gubee.controller.ProductController;
import com.n0mori.gubee.controller.TechnologyController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class TesteGubeeApplicationTests {
  @Autowired
  private MarketController marketController;

  @Autowired
  private TechnologyController technologyController;

  @Autowired
  private ProductController productController;

  @Test
  void contextLoads() {
    Assertions.assertNotNull(marketController);
    Assertions.assertNotNull(technologyController);
    Assertions.assertNotNull(productController);
  }

}
