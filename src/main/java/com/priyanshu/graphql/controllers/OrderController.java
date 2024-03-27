package com.priyanshu.graphql.controllers;

import com.priyanshu.graphql.entities.Order;
import com.priyanshu.graphql.services.OrderService;
import com.priyanshu.graphql.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.List;

public class OrderController {

    private UserService userService;
    private OrderService orderService;

    public OrderController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    // create order
    @MutationMapping
    public Order createOrder(@Argument String orderDetails, @Argument String address, @Argument int price, @Argument int userId) {
        Order order = new Order();
        order.setOrderDetails(orderDetails);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(userService.getSingleUser(userId));
        return orderService.createOrder(order);
    }

    // get all order
    @QueryMapping
    public List<Order> getOrders(){
        return orderService.getAllOrders();
    }

    // get single order
    @QueryMapping
    public Order getOrder(@Argument int orderId){
        return orderService.getSingleOrder(orderId);
    }

    // delete order
    @MutationMapping
    public boolean deleteOrder(@Argument int orderId){
        return orderService.deleteOrder(orderId);
    }
}
