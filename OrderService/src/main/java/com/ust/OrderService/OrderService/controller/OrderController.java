package com.ust.OrderService.OrderService.controller;

import com.ust.OrderService.OrderService.dto.orderDto;
import com.ust.OrderService.OrderService.fiegnClient.BookFeignClient;
import com.ust.OrderService.OrderService.model.Order;
import com.ust.OrderService.OrderService.service.OrderServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;
    @Autowired
    BookFeignClient bookFeignClient;

    @PostMapping
    public ResponseEntity<?> createAOrder(@RequestBody @Valid orderDto order){
        int quantity = bookFeignClient.getQuantity(order.bookId());

        if(order.quantity()<=quantity){
            Order order1 = toEntity(order);
            orderService.createAnOrder(order1);
            return ResponseEntity.status(HttpStatus.CREATED).body(order1);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Specified quantity is greater than Stock");
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAllOrders(){
        List<Order> order = orderService.findAllOrders();
        return ResponseEntity.status(HttpStatus.FOUND).body(order);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findAOrder(@PathVariable long id){
        Order order = orderService.findAnOrder(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateAOrder(@PathVariable long id,@RequestBody @Valid orderDto order){
        Order newOrder = new Order();
        newOrder.setOrderId(order.orderId());
        newOrder.setBookId(order.bookId());
        newOrder.setQuantity(order.quantity());
        newOrder.setStatus(order.status());
        newOrder.setCustomerId(order.customerId());
        return ResponseEntity.status(HttpStatus.FOUND).body(orderService.updateAnOrder(id,newOrder));
    }

    @DeleteMapping("/{id}")
    public void deleteAOrder(@PathVariable long id){
        orderService.deleteOrder(id);
    }

    public Order toEntity(orderDto order){
        Order newOrder = new Order();
        newOrder.setOrderId(order.orderId());
        newOrder.setBookId(order.bookId());
        newOrder.setQuantity(order.quantity());
        newOrder.setStatus(order.status());
        newOrder.setCustomerId(order.customerId());
        return newOrder;
    }
}
