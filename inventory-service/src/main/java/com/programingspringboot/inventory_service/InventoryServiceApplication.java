package com.programingspringboot.inventory_service;

import com.programingspringboot.inventory_service.model.Inventory;
import com.programingspringboot.inventory_service.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing // Ensure MongoDB auditing is enabled if needed
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            // Ensure database is empty before inserting
            if (inventoryRepository.count() == 0) {
                Inventory inventory = new Inventory();
                inventory.setSkuCode("iphone_13");
                inventory.setQuantity(100);

                Inventory inventory1 = new Inventory();
                inventory1.setSkuCode("iphone_13_red");
                inventory1.setQuantity(0);

                inventoryRepository.save(inventory);
                inventoryRepository.save(inventory1);

                System.out.println("Sample inventory data loaded into MongoDB.");
            }
        };
    }
}
