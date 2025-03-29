package com.programingspringboot.order_service.repository;

import com.programingspringboot.order_service.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, Long> {
    // You can add custom query methods if needed in the future
}
