package com.warehouse.sneakers.inventory.repository;

import com.warehouse.sneakers.inventory.model.Sneaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SneakerRepository extends JpaRepository<Sneaker, Long> {
}
