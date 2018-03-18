package com.cosmin.service.cars;

import com.cosmin.repository.cars.Car;
import com.cosmin.repository.cars.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
}
