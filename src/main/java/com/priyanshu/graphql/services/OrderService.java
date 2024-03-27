package com.priyanshu.graphql.services;

import com.priyanshu.graphql.entities.Order;
import com.priyanshu.graphql.helper.ExceptionHelper;
import com.priyanshu.graphql.repositories.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    // create order:
    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    // get all order:
    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }

    // get single order:
    public Order getSingleOrder(int orderId){
        return orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
    }

    // delete order
    public boolean deleteOrder(int orderId){
        Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        orderRepo.delete(order);
        return true;
    }
}
