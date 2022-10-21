package projectSpringBoot.projectTeam3SpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import projectSpringBoot.projectTeam3SpringBoot.entities.Car;
import projectSpringBoot.projectTeam3SpringBoot.repositories.CarRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @PostMapping
    public Car car(@RequestBody Car car){
        Car car1 = carRepository.save(car);
        return car1;
    }

    @GetMapping
    public List<Car> getCars(){
        List<Car> cars = carRepository.findAll();
        return cars;
    }

    @GetMapping("/{id}")
    public Optional<Car> getCarById(@PathVariable Long id) throws Exception{
        if (carRepository.existsById(id)){
            Optional<Car> car = carRepository.findById(id);
            return car;
        }else
            throw new Exception("The car " + id + "doesn't exist");
    }

    @PutMapping("/{id}")
    public Car carUpdate(@PathVariable Long id, @RequestBody Car car) throws Exception{
        if(carRepository.existsById(id)){
            car.setId(id);
            Car carUpdate = carRepository.save(car);
            return carUpdate;
        }else
            throw new Exception("The car " + id + " doesn't exist");
    }

    @DeleteMapping
    public void deleteAll(){
        carRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void carDelete(@PathVariable Long id){
        if(!carRepository.existsById(id))
            System.out.println(HttpStatus.CONFLICT);
        else
            carRepository.deleteById(id);
    }
}
