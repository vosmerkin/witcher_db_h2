package com.example.h2.demo.h2.controller;

import com.example.h2.demo.h2.entity.WeaponDto;
import com.example.h2.demo.h2.service.WeaponService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/weapons")
@CrossOrigin(origins = "http://localhost:3000") // For React/Angular frontend
public class WeaponController {

  private final WeaponService weaponService;

  @Autowired
  public WeaponController(WeaponService weaponService) {
    this.weaponService = weaponService;
  }

  // GET all weapons
  @GetMapping
  public ResponseEntity<List<WeaponDto>> getAllWeapons() {
    List<WeaponDto> weapons = weaponService.getAllWeapons();
    return ResponseEntity.ok(weapons);
  }

  // GET weapon by ID
  @GetMapping("/{id}")
  public ResponseEntity<WeaponDto> getWeaponById(@PathVariable Long id) {
    return weaponService
        .getWeaponById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  // GET weapons by name (partial match)
  @GetMapping("/search")
  public ResponseEntity<List<WeaponDto>> getWeaponsByName(@RequestParam String name) {
    List<WeaponDto> weapons = weaponService.getWeaponsByName(name);
    return ResponseEntity.ok(weapons);
  }

  // GET weapon by exact name
  @GetMapping("/name/{name}")
  public ResponseEntity<WeaponDto> getWeaponByExactName(@PathVariable String name) {
    return weaponService
        .getWeaponByExactName(name)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  // GET weapons by category
  @GetMapping("/category/{category}")
  public ResponseEntity<List<WeaponDto>> getWeaponsByCategory(@PathVariable String category) {
    List<WeaponDto> weapons = weaponService.getWeaponsByCategory(category);
    return ResponseEntity.ok(weapons);
  }

  // GET weapons by effect
  @GetMapping("/effect/{effect}")
  public ResponseEntity<List<WeaponDto>> getWeaponsByEffect(@PathVariable String effect) {
    List<WeaponDto> weapons = weaponService.getWeaponsByEffect(effect);
    return ResponseEntity.ok(weapons);
  }

  // GET weapons by minimum damage
  @GetMapping("/damage/greater-than/{minDamage}")
  public ResponseEntity<List<WeaponDto>> getWeaponsByMinDamage(@PathVariable Integer minDamage) {
    List<WeaponDto> weapons = weaponService.getWeaponsByMinDamage(minDamage);
    return ResponseEntity.ok(weapons);
  }

  // GET weapons by price range
  @GetMapping("/price-range")
  public ResponseEntity<List<WeaponDto>> getWeaponsByPriceRange(
      @RequestParam Integer min, @RequestParam Integer max) {
    List<WeaponDto> weapons = weaponService.getWeaponsByPriceRange(min, max);
    return ResponseEntity.ok(weapons);
  }

  // GET lightweight weapons
  @GetMapping("/lightweight/{maxWeight}")
  public ResponseEntity<List<WeaponDto>> getLightWeapons(@PathVariable Integer maxWeight) {
    List<WeaponDto> weapons = weaponService.getLightWeapons(maxWeight);
    return ResponseEntity.ok(weapons);
  }

  // POST create new weapon
  @PostMapping
  public ResponseEntity<WeaponDto> createWeapon(@Valid @RequestBody WeaponDto WeaponDto) {
    WeaponDto createdWeapon = weaponService.createWeapon(WeaponDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdWeapon);
  }

  // PUT update weapon
  @PutMapping("/{id}")
  public ResponseEntity<WeaponDto> updateWeapon(
      @PathVariable Long id, @Valid @RequestBody WeaponDto WeaponDto) {
    return weaponService
        .updateWeapon(id, WeaponDto)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  // DELETE weapon
  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, String>> deleteWeapon(@PathVariable Long id) {
    boolean deleted = weaponService.deleteWeapon(id);
    Map<String, String> response = new HashMap<>();

    if (deleted) {
      response.put("message", "Weapon deleted successfully");
      return ResponseEntity.ok(response);
    } else {
      response.put("message", "Weapon not found");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
  }

  // Exception handler for validation errors
  @ExceptionHandler
  public ResponseEntity<Map<String, String>> handleValidationExceptions(
      org.springframework.web.bind.MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult()
        .getFieldErrors()
        .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
    return ResponseEntity.badRequest().body(errors);
  }
}
