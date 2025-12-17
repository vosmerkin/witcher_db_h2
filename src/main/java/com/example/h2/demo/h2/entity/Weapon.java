package com.example.h2.demo.h2.entity;

import jakarta.persistence.*;

@Entity
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
}
