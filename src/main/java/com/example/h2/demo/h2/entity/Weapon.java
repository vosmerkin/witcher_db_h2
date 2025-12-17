package com.example.h2.demo.h2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "weapon")
public class Weapon {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String category;
  private Integer damage;
  private String effects;
  private Integer weight;
  private Integer price;

  // Default constructor
  public Weapon() {}

  // Constructor with all fields (except id)
  public Weapon(
      String name, String category, Integer damage, String effects, Integer weight, Integer price) {
    this.name = name;
    this.category = category;
    this.damage = damage;
    this.effects = effects;
    this.weight = weight;
    this.price = price;
  }

  // Constructor from DTO
  public Weapon(WeaponDto dto) {
    this.name = dto.getName();
    this.category = dto.getCategory();
    this.damage = dto.getDamage();
    this.effects = dto.getEffects();
    this.weight = dto.getWeight();
    this.price = dto.getPrice();
  }

  // Update entity from DTO
  public void updateFromDTO(WeaponDto dto) {
    this.name = dto.getName();
    this.category = dto.getCategory();
    this.damage = dto.getDamage();
    this.effects = dto.getEffects();
    this.weight = dto.getWeight();
    this.price = dto.getPrice();
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Integer getDamage() {
    return damage;
  }

  public void setDamage(Integer damage) {
    this.damage = damage;
  }

  public String getEffects() {
    return effects;
  }

  public void setEffects(String effects) {
    this.effects = effects;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }
}
