package projectSpringBoot.projectTeam3SpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import projectSpringBoot.projectTeam3SpringBoot.entities.Order;
import projectSpringBoot.projectTeam3SpringBoot.entities.Product;
import projectSpringBoot.projectTeam3SpringBoot.repositories.OrderRepository;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    EmailService emailService;
    @Autowired
    private ShopService shopService;

    public ResponseEntity<String> createOrder(Order order) throws MessagingException {
        Order order1 = orderRepository.save(order);
        String stringProduct = "";
        for (int i = 0; i < order1.getProductList().size(); i++) {
            stringProduct += order1.getProductList().get(i).getDescription() + " - " +
                    order1.getProductList().get(i).getSalePrice() + "<br>";
        }

        emailService.sendTo(
                order1.getClient().getEmailClient(),
                "BCM - Confirmation of receipt of your order - N°" + order1.getIdOrder(),
                "Your order was successful." + "<br>" +
                        "Order Sent to:" + "<br>" +
                        order1.getClient().getNameClient() + " " + order1.getClient().getSurnameClient() + ",<br>" +
                        order1.getClient().getAddress() + "<br>" +
                        stringProduct + "<br>" +
                        "Total Order: " + order1.getTotalSalePrice()
        );

        emailService.sendToShop(
                "bcm.forprogress@gmail.com",
                "You have received an order. " + "<br>",
                "This month the releases will be: " + "<br>" +
                        shopService.getDetailsString(order1.getIdOrder())
        );
        return ResponseEntity.status(HttpStatus.OK).body("Successful order create");
    }

    public Page<Order> getAllOrders(Optional<Integer> page, Optional<Integer> size) {
        Pageable pageable = null;
        if (page.isPresent() && size.isPresent()) {
            Sort sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "id"));
            pageable = PageRequest.of(page.get(), size.get(), sort);
            Page<Order> orderGet = orderRepository.findAll(pageable);
            return orderGet;
        } else {
            Page<Order> pageOrder = Page.empty();
            return pageOrder;
        }
    }

    public Optional<Order> getOrder(Long id) throws Exception {
        if (orderRepository.existsById(id)) {
            Optional<Order> order = orderRepository.findById(id);
            return order;
        } else
            throw new Exception("The order with id: " + id + ", doesn't exist");
    }

    public Order putOrder(Long id, Order order) throws Exception {
        if (orderRepository.existsById(id)) {
            order.setIdOrder(id);
            Order order1 = orderRepository.save(order);
            return order1;
        } else
            throw new Exception("Element not found");
    }

}
