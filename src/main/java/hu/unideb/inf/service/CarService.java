package hu.unideb.inf.service;

import hu.unideb.inf.model.CarDto;

import java.util.List;

public interface CarService {

    List<CarDto> getCarList();

    void createCar(CarDto carDto);

    void updateCar(CarDto carDto);

    void deleteCar(CarDto carDto);
}

