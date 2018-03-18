package com.cosmin.repository.cars;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private CarMark mark;
    private String model;

    public Long getId() {
        return id;
    }

    public Car setId(Long id) {
        this.id = id;
        return this;
    }

    public CarMark getMark() {
        return mark;
    }

    public Car setMark(CarMark mark) {
        this.mark = mark;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
