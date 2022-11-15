package projectSpringBoot.projectTeam3SpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import projectSpringBoot.projectTeam3SpringBoot.dto.ClientDTO;
import projectSpringBoot.projectTeam3SpringBoot.dto.ClientProductDTO;
import projectSpringBoot.projectTeam3SpringBoot.entities.Client;
import projectSpringBoot.projectTeam3SpringBoot.entities.Employee;
import projectSpringBoot.projectTeam3SpringBoot.entities.Order;
import projectSpringBoot.projectTeam3SpringBoot.repositories.ClientRepository;
import projectSpringBoot.projectTeam3SpringBoot.repositories.OrderRepository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;
    public List<Client> createClients(List<Client> clients) {
        List<Client> clients1 = clientRepository.saveAllAndFlush(clients);
        return clients1;
    }

    public Page<Client> getAllClients(Optional<Integer> page, Optional<Integer> size) {
        Pageable pageable = null;
        if (page.isPresent() && size.isPresent()) {
            Sort sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "idClient"));
            pageable = PageRequest.of(page.get(), size.get(), sort);
            Page<Client> ClientGet = clientRepository.findAll(pageable);
            return ClientGet;
        } else {
            Page<Client> pageEmployee = Page.empty();
            return pageEmployee;
        }
    }

    public Optional<Client> getClient(Long id) throws Exception {
        if (clientRepository.existsById(id)) {
            Optional<Client> client = clientRepository.findById(id);
            return client;
        } else
            throw new Exception("The client " + id + " doesn't exist");
    }

    public ClientDTO getInformatioOrder(Long id) {
        Optional<Order> order = orderRepository.findById(id);

        List<ClientProductDTO> clientProductDTOList = new ArrayList<>();

        for (int i = 0; i < order.get().getProductList().size(); i++) {
            clientProductDTOList.add(new ClientProductDTO(
                    order.get().getProductList().get(i).getDescription(),
                    order.get().getProductList().get(i).getType(),
                    order.get().getProductList().get(i).getSalePrice()
            ));
        }
        ClientDTO dto = new ClientDTO();
        dto.setId(order.get().getClient().getIdClient());
        dto.setName(order.get().getClient().getNameClient());
        dto.setSurname(order.get().getClient().getSurnameClient());
        dto.setIdOrder(order.get().getIdOrder());
        dto.setProducts(clientProductDTOList);
        dto.setTotalcost(order.get().getTotalSalePrice());

        return dto;
    }

    public Client clientUpdate(Long id, Client client) throws Exception {
        if (clientRepository.existsById(id)) {
            client.setIdClient(id);
            Client clientUpdate = clientRepository.save(client);
            return clientUpdate;
        } else
            throw new Exception("The client " + id + " doesn't exist");
    }

    public void clientDelete(Long id) {
        if (!clientRepository.existsById(id))
            System.out.println(HttpStatus.CONFLICT);
        else
            clientRepository.deleteById(id);
    }


}
