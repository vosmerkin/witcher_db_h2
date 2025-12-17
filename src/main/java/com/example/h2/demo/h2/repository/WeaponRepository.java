package com.example.h2.demo.h2.repository;

import com.example.h2.demo.h2.entity.Weapon;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Long> {

  // Find by name (case-insensitive partial match)
  List<Weapon> findByNameContainingIgnoreCase(String name);

  // Find by exact name
  Optional<Weapon> findByName(String name);

  // Find by category
  List<Weapon> findByCategory(String category);

  // Find weapons with damage greater than specified value
  List<Weapon> findByDamageGreaterThan(Integer damage);

  // Find weapons within price range
  List<Weapon> findByPriceBetween(Integer minPrice, Integer maxPrice);

  // Find by category and minimum damage
  List<Weapon> findByCategoryAndDamageGreaterThan(String category, Integer minDamage);

  // Custom query using JPQL
  @Query("SELECT w FROM Weapon w WHERE w.effects LIKE %:effect%")
  List<Weapon> findByEffectContaining(@Param("effect") String effect);

  // Find lightweight weapons
  @Query("SELECT w FROM Weapon w WHERE w.weight <= :maxWeight ORDER BY w.weight ASC")
  List<Weapon> findLightWeapons(@Param("maxWeight") Integer maxWeight);
}
