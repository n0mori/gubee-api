package com.n0mori.gubee;

import com.n0mori.gubee.controller.MarketController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TesteGubeeApplicationTests {
  @Autowired
  private MarketController marketController;

  @Test
  void contextLoads() {
    Assertions.assertNotNull(marketController);
  }

}
