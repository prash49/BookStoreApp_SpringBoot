package com.bridgelabz.bookstoreapp.repository;

import com.bridgelabz.bookstoreapp.model.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderData, Integer> {

    List<OrderData> findAllByUserId(int id);
}
