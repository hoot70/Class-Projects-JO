package com.example.demo.Domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<CarInfo, Long> {

    List<CarInfo> findByMake(String make);

    List<CarInfo> findByColor(String color);

    List<CarInfo> findByYear(int year);

    List<CarInfo> findByModel(String model);
}
