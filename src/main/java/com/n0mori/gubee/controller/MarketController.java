package com.n0mori.gubee.controller;

import com.n0mori.gubee.model.Market;
import com.n0mori.gubee.repository.MarketRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/market", produces = MediaType.APPLICATION_JSON_VALUE)
public class MarketController {
  @Autowired private MarketRepository marketRepository;

  @GetMapping("")
  public List<Market> getAllMarkets() {
    return marketRepository.findAll();
  }

  @GetMapping("/{id}")
  public Market getMarket(@PathVariable("id") Integer id) {
    Optional<Market> market = marketRepository.findById(id);

    if (market.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    return market.get();
  }
}
