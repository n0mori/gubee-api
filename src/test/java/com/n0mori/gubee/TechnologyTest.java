package com.n0mori.gubee;

import com.n0mori.gubee.model.Technology;
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
class TechnologyTest {
  private final String IP = "http://localhost:";

  @LocalServerPort private int port;

  @Autowired private TestRestTemplate restTemplate;

  @Test
  void buscarStack() {
    Technology[] technologies =
        restTemplate.getForObject(IP + port + "/technology", Technology[].class);
    Assertions.assertNotNull(technologies);
    Assertions.assertEquals(11, technologies.length);
    Arrays.stream(technologies)
        .forEach(
            t -> {
              Assertions.assertNotNull(t.getId());
              Assertions.assertNotNull(t.getName());
              Assertions.assertFalse(t.getName().isBlank());
            });
  }

  @Test
  void buscarTechnology() {
    Technology technology =
        restTemplate.getForObject(
            IP + port + "/technology/{id}", Technology.class, Map.of("id", 1));
    Assertions.assertNotNull(technology);
    Assertions.assertEquals(1, technology.getId());
    Assertions.assertEquals("Java 10", technology.getName());
  }
}
