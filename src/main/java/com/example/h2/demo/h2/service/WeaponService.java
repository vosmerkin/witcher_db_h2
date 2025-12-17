package com.example.h2.demo.h2.service;

import com.example.h2.demo.h2.entity.Weapon;
import com.example.h2.demo.h2.entity.WeaponDto;
import com.example.h2.demo.h2.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WeaponService {

  private final WeaponRepository weaponRepository;

  @Autowired
  public WeaponService(WeaponRepository weaponRepository) {
    this.weaponRepository = weaponRepository;
  }

  // Convert Entity to DTO
  private WeaponDto convertToDTO(Weapon weapon) {
    return new WeaponDto(
        weapon.getId(),
        weapon.getName(),
        weapon.getCategory(),
        weapon.getDamage(),
        weapon.getEffects(),
        weapon.getWeight(),
        weapon.getPrice());
  }

  // Get all weapons
  @Transactional(readOnly = true)
  public List<WeaponDto> getAllWeapons() {
    return weaponRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
  }

  // Get weapon by ID
  @Transactional(readOnly = true)
  public Optional<WeaponDto> getWeaponById(Long id) {
    return weaponRepository.findById(id).map(this::convertToDTO);
  }

  // Get weapons by name (partial match)
  @Transactional(readOnly = true)
  public List<WeaponDto> getWeaponsByName(String name) {
    return weaponRepository.findByNameContainingIgnoreCase(name).stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  // Get weapon by exact name
  @Transactional(readOnly = true)
  public Optional<WeaponDto> getWeaponByExactName(String name) {
    return weaponRepository.findByName(name).map(this::convertToDTO);
  }

  // Get weapons by category
  @Transactional(readOnly = true)
  public List<WeaponDto> getWeaponsByCategory(String category) {
    return weaponRepository.findByCategory(category).stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  // Get weapons by effect
  @Transactional(readOnly = true)
  public List<WeaponDto> getWeaponsByEffect(String effect) {
    return weaponRepository.findByEffectContaining(effect).stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  // Create new weapon
  @Transactional
  public WeaponDto createWeapon(WeaponDto WeaponDto) {
    Weapon weapon = new Weapon(WeaponDto);
    Weapon savedWeapon = weaponRepository.save(weapon);
    return convertToDTO(savedWeapon);
  }

  // Update existing weapon
  @Transactional
  public Optional<WeaponDto> updateWeapon(Long id, WeaponDto WeaponDto) {
    return weaponRepository
        .findById(id)
        .map(
            existingWeapon -> {
              existingWeapon.updateFromDTO(WeaponDto);
              Weapon updatedWeapon = weaponRepository.save(existingWeapon);
              return convertToDTO(updatedWeapon);
            });
  }

  // Delete weapon
  @Transactional
  public boolean deleteWeapon(Long id) {
    if (weaponRepository.existsById(id)) {
      weaponRepository.deleteById(id);
      return true;
    }
    return false;
  }

  // Get weapons with damage greater than
  @Transactional(readOnly = true)
  public List<WeaponDto> getWeaponsByMinDamage(Integer minDamage) {
    return weaponRepository.findByDamageGreaterThan(minDamage).stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  // Get weapons within price range
  @Transactional(readOnly = true)
  public List<WeaponDto> getWeaponsByPriceRange(Integer minPrice, Integer maxPrice) {
    return weaponRepository.findByPriceBetween(minPrice, maxPrice).stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  // Get lightweight weapons
  @Transactional(readOnly = true)
  public List<WeaponDto> getLightWeapons(Integer maxWeight) {
    return weaponRepository.findLightWeapons(maxWeight).stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }
}
