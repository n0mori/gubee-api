package com.n0mori.gubee.repository;

import com.n0mori.gubee.model.Technology;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TechnologyRepository extends CrudRepository<Technology, Integer> {
  List<Technology> findAll();

}
