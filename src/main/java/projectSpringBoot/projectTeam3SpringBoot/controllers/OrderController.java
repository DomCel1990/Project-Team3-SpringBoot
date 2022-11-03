package projectSpringBoot.projectTeam3SpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import projectSpringBoot.projectTeam3SpringBoot.entities.Client;
import projectSpringBoot.projectTeam3SpringBoot.entities.Order;
import projectSpringBoot.projectTeam3SpringBoot.repositories.ClientRepository;
import projectSpringBoot.projectTeam3SpringBoot.repositories.EmployeeRepository;
import projectSpringBoot.projectTeam3SpringBoot.repositories.OrderRepository;
import projectSpringBoot.projectTeam3SpringBoot.repositories.ProductRepository;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/order")
    public Order placeOrder(@RequestBody Order order){
        return orderRepository.save(order);
    }
    @GetMapping("/findAllOrders")
    public List<Order>findAllOrders(){
        return  orderRepository.findByStatus();
    }
}
