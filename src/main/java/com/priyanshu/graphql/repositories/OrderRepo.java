package com.priyanshu.graphql.repositories;

import com.priyanshu.graphql.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {



}
