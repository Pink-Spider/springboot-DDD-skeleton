package io.pinkspider.dddskeleton.api.order;

import io.pinkspider.dddskeleton.application.order.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void create(@RequestParam Long id, @RequestParam String name) {
        orderService.handle(id, name);
    }
}
