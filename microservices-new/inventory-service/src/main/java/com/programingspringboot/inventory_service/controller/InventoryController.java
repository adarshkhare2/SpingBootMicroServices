package com.programingspringboot.inventory_service.controller;
import com.programingspringboot.inventory_service.dto.InventoryResponse;
import com.programingspringboot.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {
    private final InventoryService inventoryService;

    // http://localhost:8082/api/inventory/iphone-13,iphone13-red

    // http://localhost:8082/api/inventory?skuCode=iphone-13&skuCode=iphone13-red
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
        return inventoryService.isInStock(skuCode);
    }
}

/*

Json for postman :- http://localhost:8082/api/order
{
        "orderLineItemsDtoList": [
        {
        "skuCode": "iphone_13",
        "price": 1200,
        "quantity": 1
        },
        {
        "skuCode": "iphone_13_red",
        "price": 1200,
        "quantity": 1
        }
        ]
        }
*/
