package projectSpringBoot.projectTeam3SpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import projectSpringBoot.projectTeam3SpringBoot.entities.Car;
import projectSpringBoot.projectTeam3SpringBoot.repositories.CarRepository;
import projectSpringBoot.projectTeam3SpringBoot.services.CarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarRepository carRepository;
    @Autowired
    CarService carService;

    @PostMapping("/create")
    public Car car(@RequestBody Car car) {
        Car car1 = carRepository.save(car);
        return car1;
    }

    @PostMapping("/creates")
    public List<Car> createCars(@RequestBody List<Car> cars) {
        return carService.createCars(cars);
    }

    @GetMapping("/gets")
    public Page<Car> getCars(@RequestParam(required = false) Optional<Integer> page, @RequestParam(required = false) Optional<Integer> size) {
        return carService.getCars(page, size);
    }

    @GetMapping("/get/{id}")
    public Optional<Car> getCarById(@PathVariable Long id) throws Exception {
        return carService.getCarById(id);
    }

    @PutMapping("/update/{id}")
    public Car carUpdate(@PathVariable Long id, @RequestBody Car car) throws Exception {
       return carService.carUpdate(id,car);
    }

    @DeleteMapping("deletes")
    public void deleteAll() {
        carRepository.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void carDelete(@PathVariable Long id) {
        carService.carDelete(id);
    }
}
