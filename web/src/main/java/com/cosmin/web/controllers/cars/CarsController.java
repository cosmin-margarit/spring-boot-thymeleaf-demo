package com.cosmin.web.controllers.cars;

import com.cosmin.repository.cars.Car;
import com.cosmin.service.cars.CarService;
import com.cosmin.service.cars.Filters;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/", "/cars"})
public class CarsController {
    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String index(Filters filters, ModelMap modelMap) {
        Page<Car> carPage = carService.findAll(filters);
        modelMap.put("cars", carPage);
        modelMap.put("filters", filters);
        return "cars/index";
    }
}
