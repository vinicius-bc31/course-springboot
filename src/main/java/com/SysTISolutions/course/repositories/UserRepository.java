package com.SysTISolutions.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SysTISolutions.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
