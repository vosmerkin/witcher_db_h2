package com.example.h2.demo.h2.entity;


import jakarta.validation.constraints.*;

public class WeaponDto {

    private Long id;

    @NotBlank(message = "Weapon name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "Damage is required")
    @Min(value = 1, message = "Damage must be at least 1")
    @Max(value = 1000, message = "Damage cannot exceed 1000")
    private Integer damage;

    private String effects;

    @NotNull(message = "Weight is required")
    @Min(value = 0, message = "Weight cannot be negative")
    @Max(value = 100, message = "Weight cannot exceed 100")
    private Integer weight;

    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price cannot be negative")
    private Integer price;

    // Constructors
    public WeaponDto() {}

    public WeaponDto(Long id, String name, String category, Integer damage,
                     String effects, Integer weight, Integer price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.damage = damage;
        this.effects = effects;
        this.weight = weight;
        this.price = price;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Integer getDamage() { return damage; }
    public void setDamage(Integer damage) { this.damage = damage; }

    public String getEffects() { return effects; }
    public void setEffects(String effects) { this.effects = effects; }

    public Integer getWeight() { return weight; }
    public void setWeight(Integer weight) { this.weight = weight; }

    public Integer getPrice() { return price; }
    public void setPrice(Integer price) { this.price = price; }
}