package edu.dali.hotel.service.implement;

import edu.dali.hotel.model.OrderEntity;
import edu.dali.hotel.repository.OrderRepository;
import edu.dali.hotel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Order implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    @Override
    public OrderEntity saveOrder(OrderEntity order) {
        return orderRepository.save(order);
    }

}
