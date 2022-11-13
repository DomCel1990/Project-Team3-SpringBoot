package projectSpringBoot.projectTeam3SpringBoot.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projectSpringBoot.projectTeam3SpringBoot.entities.Shop;
import projectSpringBoot.projectTeam3SpringBoot.repositories.ShopRepository;
import projectSpringBoot.projectTeam3SpringBoot.services.ShopService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/shop")
public class ShopController {

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    ShopService shopService;

    @GetMapping("/getAll")
    @ApiOperation(value = "Get all the shops", notes = "Makes a list with all the shops")
    public List<Shop> getShop() {
        List<Shop> shop = shopRepository.findAll();
        return shop;
    }
    @GetMapping("/cost/{id}")
    @ApiOperation(value = "Get shop's costs", notes = "Gets the shop's management costs by its id")
    public String getCost(@PathVariable Long id){
        return shopService.getManagementCost(id);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get one product", notes = "Gets a product using its id")
    public Shop getOneProduct(@PathVariable Long id) {
        Optional<Shop> shop = shopRepository.findById(id);
        return shop.get();
    }

    @PostMapping("/post")
    @ApiOperation(value = "Create shops", notes = "Creates a new shop")
    public Shop shop(@RequestBody Shop s) {
        Shop shop = shopRepository.save(s);
        return shop;
    }

    @PutMapping("/put")
    @ApiOperation(value = "Update shop", notes = "Checks if the shop exists, if yes it'll edit it, if not it'll give an exception")
    public Shop putShop(@PathVariable Long id, @RequestBody Shop shop) throws Exception {
        if (shopRepository.existsById(id)) {
            shop.setId(id);
            Shop shop1 = shopRepository.save(shop);
            return shop1;
        } else
            throw new Exception("Element not found");
    }

    @DeleteMapping("/deleteAll")
    @ApiOperation(value = "Delete the shops", notes = "Deletes all the shops")
    public void deleteAll() {shopRepository.deleteAll();}

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a shop", notes = "Deletes a shop through its id")
    public void deleteById(@PathVariable Long id) {shopRepository.deleteById(id);}
}


