package com.ust.OrderService.OrderService.service;

import com.ust.OrderService.OrderService.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAllOrders();
    Order findAnOrder(long id);
    Order createAnOrder(Order Order);
    Order updateAnOrder(long id, Order Order);
    void deleteOrder(long id);
}
