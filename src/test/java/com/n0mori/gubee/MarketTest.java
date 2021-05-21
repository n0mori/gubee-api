package com.n0mori.gubee;

import com.n0mori.gubee.model.Market;
import java.util.Arrays;
import java.util.Map;
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
class MarketTest {
  private final String IP = "http://localhost:";

  @LocalServerPort private int port;

  @Autowired private TestRestTemplate restTemplate;

  @Test
  void buscarMarkets() {
    Market[] markets = restTemplate.getForObject(IP + port + "/market", Market[].class);
    Assertions.assertNotNull(markets);
    Assertions.assertEquals(8, markets.length);
    Arrays.stream(markets)
        .forEach(
            m -> {
              Assertions.assertNotNull(m.getId());
              Assertions.assertNotNull(m.getName());
              Assertions.assertFalse(m.getName().isBlank());
            });
  }

  @Test
  void buscarMarket() {
    Market market =
        restTemplate.getForObject(IP + port + "/market/{id}", Market.class, Map.of("id", 1));
    Assertions.assertNotNull(market);
    Assertions.assertEquals(1, market.getId());
    Assertions.assertEquals("Ecommerce", market.getName());
  }
}
