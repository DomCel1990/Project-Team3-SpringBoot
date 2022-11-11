package projectSpringBoot.projectTeam3SpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import projectSpringBoot.projectTeam3SpringBoot.entities.Order;
import projectSpringBoot.projectTeam3SpringBoot.repositories.OrderRepository;

import javax.mail.MessagingException;


@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    EmailService emailService;

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
        return ResponseEntity.status(HttpStatus.OK).body("Successful order create");
    }
}
