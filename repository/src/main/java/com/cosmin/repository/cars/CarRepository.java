package com.cosmin.repository.cars;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarRepository extends PagingAndSortingRepository<Car, Long> {
}
