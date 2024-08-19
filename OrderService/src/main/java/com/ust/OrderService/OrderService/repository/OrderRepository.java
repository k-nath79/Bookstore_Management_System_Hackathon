package com.ust.OrderService.OrderService.repository;

import com.ust.OrderService.OrderService.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
