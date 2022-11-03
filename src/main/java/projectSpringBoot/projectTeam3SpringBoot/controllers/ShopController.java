package projectSpringBoot.projectTeam3SpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projectSpringBoot.projectTeam3SpringBoot.entities.Shop;
import projectSpringBoot.projectTeam3SpringBoot.repositories.ShopRepository;
import projectSpringBoot.projectTeam3SpringBoot.services.ShopService;

import java.util.List;

@RestController
@RequestMapping(value = "/shop")
public class ShopController {

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    ShopService shopService;
    @GetMapping("/getAll")
    public List<Shop> getShop() {
        List<Shop> shop = shopRepository.findAll();
        return shop;
    }
    @GetMapping("/cost/{id}")
    public String getCost(@PathVariable Long id){
        return shopService.getManagementCost(id);
    }

    @GetMapping("/{id}")
    public Shop getOneProduct(@PathVariable Long id) {
        Shop shop = shopRepository.getById(id);
        return shop;
    }

    @PostMapping("/post")
    public Shop shop(@RequestBody Shop s) {
        Shop shop = shopRepository.save(s);
        return shop;
    }

    @PutMapping("/put")
    public Shop putShop(@PathVariable Long id, @RequestBody Shop shop) throws Exception {
        if (shopRepository.existsById(id)) {
            shop.setId(id);
            Shop shop1 = shopRepository.save(shop);
            return shop1;
        } else
            throw new Exception("Element not found");
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {shopRepository.deleteAll();}

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {shopRepository.deleteById(id);}
}


