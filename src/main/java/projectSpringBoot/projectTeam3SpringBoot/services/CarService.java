package projectSpringBoot.projectTeam3SpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import projectSpringBoot.projectTeam3SpringBoot.entities.Car;
import projectSpringBoot.projectTeam3SpringBoot.entities.Employee;
import projectSpringBoot.projectTeam3SpringBoot.repositories.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<Car> createCars(List<Car> cars) {
        List<Car> carList = carRepository.saveAllAndFlush(cars);
        return carList;
    }

    public Page<Car> getCars(Optional<Integer> page, Optional<Integer> size) {
        Pageable pageable = null;
        if (page.isPresent() && size.isPresent()) {
            Sort sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "id"));
            pageable = PageRequest.of(page.get(), size.get(), sort);
            Page<Car> getCar = carRepository.findAll(pageable);
            return getCar;
        } else {
            Page<Car> pageCar = Page.empty();
            return pageCar;
        }
    }
    public Optional<Car> getCarById(Long id) throws Exception{
        if (carRepository.existsById(id)){
            Optional<Car> car = carRepository.findById(id);
            return car;
        }else
            throw new Exception("The car " + id + "doesn't exist");
    }
    public Car carUpdate(Long id, Car car) throws Exception {
        if (carRepository.existsById(id)) {
            car.setId(id);
            Car carUpdate = carRepository.save(car);
            return carUpdate;
        } else
            throw new Exception("The car " + id + " doesn't exist");
    }

    public void carDelete(Long id) {
        if (!carRepository.existsById(id))
            System.out.println(HttpStatus.CONFLICT);
        else
            carRepository.deleteById(id);
    }
}
