package edu.dali.hotel.service;

import edu.dali.hotel.model.OrderEntity;

import java.util.List;

public interface OrderService {
    OrderEntity saveOrder(OrderEntity order);
}
