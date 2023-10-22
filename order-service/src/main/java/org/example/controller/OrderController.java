package org.example.controller;

import org.example.dto.OrderRequestDto;
import org.example.entity.PurchaseOrder;
import org.example.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;
    @PostMapping("/createOrder")
    public PurchaseOrder createOrder(@RequestBody OrderRequestDto orderRequestDto){

        return orderService.createOrder(orderRequestDto);
    }

    @GetMapping("/")
    public List<PurchaseOrder> getAllOrders(){
        return orderService.getAllOrders();
    }
}
