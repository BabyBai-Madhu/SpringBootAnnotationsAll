package com.example.SpringBootAnnotations.controller;

import com.example.SpringBootAnnotations.entity.Order;
import com.example.SpringBootAnnotations.repository.OrderRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @PostConstruct
    public void initOrder() {
        orderRepository.saveAll(Stream.of(
                new Order("madhu", "IT", "black", 33.0),
                new Order("baby", "electronics", "white", 50000.0)
        ).collect(Collectors.toList()));
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{category}")
    public List<Order> fetchByCategory(@PathVariable String category) {
        return orderRepository.findByCategory(category);
    }
}