package com.n0mori.gubee.controller;

import com.n0mori.gubee.model.Technology;
import com.n0mori.gubee.repository.TechnologyRepository;
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
@RequestMapping(value = "/technology", produces = MediaType.APPLICATION_JSON_VALUE)
public class TechnologyController {
  @Autowired
  private TechnologyRepository technologyRepository;

  @GetMapping("")
  public List<Technology> getAllTechnologies() {
    return technologyRepository.findAll();
  }

  @GetMapping("/{id}")
  public Technology getTechnology(@PathVariable("id") Integer id) {
    Optional<Technology> technology = technologyRepository.findById(id);

    if (technology.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    return technology.get();
  }
}
