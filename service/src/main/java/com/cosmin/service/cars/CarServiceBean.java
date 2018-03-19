package com.cosmin.service.cars;

import com.cosmin.repository.cars.Car;
import com.cosmin.repository.cars.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CarServiceBean implements CarService {
    private final CarRepository carRepository;

    public CarServiceBean(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public Page<Car> findAll(Filters filters) {
        return carRepository.findAll(new PageRequest(filters.getPage(), filters.getPageSize()));
    }

    @Override
    public Car read(Long carId) {
        Car car = carRepository.findOne(carId);
        if (car == null) {
            throw new RuntimeException("Car not found!");
        }
        return car;
    }

    @Override
    public Car save(Car dbCar) {
        return carRepository.save(dbCar);
    }

    @Override
    public void delete(Long id) {
        Car read = read(id);
        carRepository.delete(read);
    }
}
