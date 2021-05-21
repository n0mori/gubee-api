package com.n0mori.gubee.repository;

import com.n0mori.gubee.model.Market;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface MarketRepository extends CrudRepository<Market, Integer> {
  List<Market> findAll();
}
