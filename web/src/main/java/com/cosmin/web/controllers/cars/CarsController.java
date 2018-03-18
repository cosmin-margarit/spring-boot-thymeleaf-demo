package com.cosmin.web.controllers.cars;

import com.cosmin.repository.cars.Car;
import com.cosmin.repository.cars.CarMarque;
import com.cosmin.service.cars.CarService;
import com.cosmin.service.cars.Filters;
import com.cosmin.service.utils.BeanUtils;
import com.cosmin.web.FlashMessage;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.ConstraintViolationException;

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

    @GetMapping(value = "/create")
    public String create(ModelMap modelMap) {
        modelMap.putIfAbsent("car", new Car());
        prepareEditModel(modelMap);
        return "cars/edit";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable(name = "id") Long carId, ModelMap modelMap) {
        modelMap.put("car", carService.read(carId));
        prepareEditModel(modelMap);
        return "cars/edit";
    }

    @GetMapping(value = "/{id}")
    public String details(@PathVariable Long id, ModelMap model) {
        Car car = carService.read(id);
        model.put("car", car);
        return "cars/details";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute Car car,
                       RedirectAttributes redirectAttrs,
                       ModelMap model) {
        Car dbCar = car.getId() != null ? carService.read(car.getId()) : new Car();
        BeanUtils.copyPropertiesNotNull(car, dbCar);

        try {
            dbCar = carService.save(dbCar);
        } catch (ConstraintViolationException e) {
            model.put("car", car);
            model.put("constraints", e.getConstraintViolations());
            return create(model);
        }

        FlashMessage.ok(redirectAttrs, "Car #" + dbCar.getId() + " was saved successfully");
        redirectAttrs.addFlashAttribute("notification", FlashMessage.ok(""));
        return "redirect:/cars/";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        carService.delete(id);
        return "redirect:/cars/";
    }


    private void prepareEditModel(ModelMap modelMap) {
        modelMap.put("carMarques", CarMarque.values());
    }
}
