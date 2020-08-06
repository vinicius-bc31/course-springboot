package com.SysTISolutions.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SysTISolutions.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
