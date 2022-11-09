package projectSpringBoot.projectTeam3SpringBoot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projectSpringBoot.projectTeam3SpringBoot.entities.Order;
import projectSpringBoot.projectTeam3SpringBoot.repositories.ClientRepository;
import projectSpringBoot.projectTeam3SpringBoot.repositories.OrderRepository;
import projectSpringBoot.projectTeam3SpringBoot.services.OrderService;

import javax.mail.MessagingException;

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
    public ResponseEntity<String> createOrder(@RequestBody Order order) throws MessagingException {
        return orderService.createOrder(order);
    }





}
