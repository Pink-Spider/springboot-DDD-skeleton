package io.pinkspider.dddskeleton.application.order;

import io.pinkspider.dddskeleton.domain.order.Order;
import io.pinkspider.dddskeleton.domain.order.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void handle(Long id, String name) {
        Order order = new Order(id, name);
        orderRepository.save(order);
    }
}
