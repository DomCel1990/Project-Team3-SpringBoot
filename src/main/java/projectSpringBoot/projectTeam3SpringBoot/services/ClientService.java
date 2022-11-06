package projectSpringBoot.projectTeam3SpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import projectSpringBoot.projectTeam3SpringBoot.entities.Client;
import projectSpringBoot.projectTeam3SpringBoot.repositories.ClientRepository;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Page<Client> getAllClients(Optional<Integer> page, Optional<Integer> size) {
        Pageable pageable = null;
        if (page.isPresent() && size.isPresent()) {
            Sort sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "id"));
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

    public Client clientUpdate(Long id, Client client) throws Exception{
        if(clientRepository.existsById(id)){
            client.setId(id);
            Client clientUpdate = clientRepository.save(client);
            return clientUpdate;
        }else
            throw new Exception("The client " + id + " doesn't exist");
    }

    public void clientDelete(Long id){
        if(!clientRepository.existsById(id))
            System.out.println(HttpStatus.CONFLICT);
        else
            clientRepository.deleteById(id);
    }
}
