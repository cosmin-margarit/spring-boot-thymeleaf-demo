package com.cosmin.service.cars;

import com.cosmin.repository.cars.Car;
import org.springframework.data.domain.Page;

public interface CarService {

    Page<Car> findAll(Filters filters);
}
