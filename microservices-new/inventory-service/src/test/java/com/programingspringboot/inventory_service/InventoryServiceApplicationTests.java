package com.programingspringboot.inventory_service;

import com.programingspringboot.inventory_service.repository.InventoryRepository;
import com.programingspringboot.inventory_service.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class InventoryServiceApplicationTests {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private InventoryService inventoryService;

	@Test
	void contextLoads() {
		assertThat(inventoryRepository).isNotNull();
		assertThat(inventoryService).isNotNull();
	}
}
