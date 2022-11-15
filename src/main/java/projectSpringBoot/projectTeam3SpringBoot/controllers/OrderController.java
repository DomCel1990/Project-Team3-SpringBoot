package projectSpringBoot.projectTeam3SpringBoot.controllers;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectSpringBoot.projectTeam3SpringBoot.entities.Order;
import projectSpringBoot.projectTeam3SpringBoot.entities.Product;
import projectSpringBoot.projectTeam3SpringBoot.repositories.ClientRepository;
import projectSpringBoot.projectTeam3SpringBoot.repositories.OrderRepository;
import projectSpringBoot.projectTeam3SpringBoot.services.OrderService;

import javax.mail.MessagingException;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping
    @ApiOperation(value = "Create orders", notes = "Creates and saves orders")
    public ResponseEntity<String> createOrder(@RequestBody Order order) throws MessagingException {
        return orderService.createOrder(order);
    }

    @GetMapping
    @ApiOperation(value = "Find orders", notes = "Finds all the orders and inserts them into a layout, sorting them by ID")
    public Page<Order> getAllOrders(@RequestParam(required = false) Optional<Integer> page, @RequestParam(required = false) Optional<Integer> size) {
        return orderService.getAllOrders(page, size);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find an order", notes = "Finds an order by ID")
    public Optional<Order> getOneOrder(@PathVariable Long id) throws Exception {
        return orderService.getOrder(id);
    }

    @PutMapping
    @ApiOperation(value = "Order update", notes = "Edits an order by calling it through the ID")
    public Order putOrder(@PathVariable Long id, @RequestBody Order order) throws Exception {
        return orderService.putOrder(id, order);
    }

    @DeleteMapping
    @ApiOperation(value = "Orders delete", notes = "Deletes all the order")
    public void deleteAll() {
        orderRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Order delete", notes = "Deletes an order by calling it through the ID")
    public void deleteById(@PathVariable Long id) {
        orderRepository.deleteById(id);
    }
}
