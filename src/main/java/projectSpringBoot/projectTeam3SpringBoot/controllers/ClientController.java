package projectSpringBoot.projectTeam3SpringBoot.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import projectSpringBoot.projectTeam3SpringBoot.dto.ClientDTO;
import projectSpringBoot.projectTeam3SpringBoot.entities.Client;
import projectSpringBoot.projectTeam3SpringBoot.repositories.ClientRepository;
import projectSpringBoot.projectTeam3SpringBoot.services.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ClientService clientService;

    @PostMapping
    @ApiOperation(value = "Create clients", notes = "Takes and saves a list of clients")
    public List<Client> createClients(@RequestBody  List<Client> clients){
        return clientService.createClients(clients);
    }

    @GetMapping
    @ApiOperation(value = "Get all the clients", notes = "Makes a page with all the clients")
    public Page<Client> getAllClients(@RequestParam(required = false) Optional<Integer> page, @RequestParam(required = false) Optional<Integer> size){
        return clientService.getAllClients(page, size);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get one client", notes = "Gets a client using his id")
    public Optional<Client> getClient(@PathVariable Long id) throws Exception {
        return clientService.getClient(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update client", notes = "Finds a client using his id and edits him")
    public Client clientUpdate(@PathVariable Long id, @RequestBody Client client) throws Exception{
        return clientService.clientUpdate(id, client);
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Delete the clients", notes = "Deletes all the clients")
    public void deleteAll(){
        clientRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete client", notes = "Deletes a client through his id")
    public void clientDelete(@PathVariable Long id){
        clientService.clientDelete(id);
    }
}
