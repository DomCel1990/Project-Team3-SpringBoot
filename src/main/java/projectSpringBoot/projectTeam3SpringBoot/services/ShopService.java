package projectSpringBoot.projectTeam3SpringBoot.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectSpringBoot.projectTeam3SpringBoot.dto.ShopDTO;
import projectSpringBoot.projectTeam3SpringBoot.entities.Order;
import projectSpringBoot.projectTeam3SpringBoot.repositories.OrderRepository;
import projectSpringBoot.projectTeam3SpringBoot.repositories.ShopRepository;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ShopService {

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    private OrderRepository orderRepository;

    public String getManagementCost(Long id) {
        String s = shopRepository.findById(id).get().managementCost();
        return s;
    }

    public ShopDTO getDetails(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        List<Order> orders = orderRepository.findAll();
        double sum = 0;
        for (int i = 0; i <orders.size() ; i++) {
            sum+= orders.get(i).getTotalSalePrice();
        }
        ShopDTO dto = new ShopDTO();
        dto.setName(order.get().getShop().getName());
        dto.setCostEmployee(order.get().getShop().costEmployees());
        dto.setCostProduct(order.get().getShop().costProduct());
        dto.setEntryOrder(sum);
        return dto;
    }
    public String getDetailsString(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        List<Order> orders = orderRepository.findAll();
        ShopDTO dto = new ShopDTO();
        double sum = 0;
        for (int i = 0; i <orders.size() ; i++) {
            sum+= orders.get(i).getTotalSalePrice();

            dto.setName(orders.get(i).getShop().getName());
            dto.setCostEmployee(orders.get(i).getShop().costEmployees());
            dto.setCostProduct(orders.get(i).getShop().costProduct());
            dto.setEntryOrder(sum);


        }
        return dto.toString();
    }


}
