package com.ust.OrderService.OrderService.fiegnClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BookService",url = "http://localhost:8100")
public interface BookFeignClient {
    @GetMapping("/api/book/getquantity/{id}")
    int getQuantity(@PathVariable long id);
}
