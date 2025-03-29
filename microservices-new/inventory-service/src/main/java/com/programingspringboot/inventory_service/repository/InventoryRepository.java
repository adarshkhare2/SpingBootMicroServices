package com.programingspringboot.inventory_service.repository;

import com.programingspringboot.inventory_service.model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InventoryRepository extends MongoRepository<Inventory, Long> {
    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}