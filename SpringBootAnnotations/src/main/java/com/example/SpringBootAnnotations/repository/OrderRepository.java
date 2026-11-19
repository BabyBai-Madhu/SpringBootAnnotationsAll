package com.example.SpringBootAnnotations.repository;

import com.example.SpringBootAnnotations.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

   List<Order> findByCategory(String category);

}
