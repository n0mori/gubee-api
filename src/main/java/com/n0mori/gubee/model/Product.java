package com.n0mori.gubee.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @JsonProperty("productName")
  @Column(unique = true)
  private String name;

  private String description;

  @ManyToMany
  @JoinTable(
      name = "product_market",
      joinColumns = @JoinColumn(name = "product_id"),
      inverseJoinColumns = @JoinColumn(name = "market_id")
  )
  private List<Market> targetMarket;

  @ManyToMany()
  @JoinTable(
      name = "product_stack",
      joinColumns = @JoinColumn(name = "product_id"),
      inverseJoinColumns = @JoinColumn(name = "technology_id")
  )
  private List<Technology> stack;


}
