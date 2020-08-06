package com.SysTISolutions.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SysTISolutions.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
