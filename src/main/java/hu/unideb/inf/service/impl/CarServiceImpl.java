package hu.unideb.inf.service.impl;

import hu.unideb.inf.entity.Car;
import hu.unideb.inf.model.CarDto;
import hu.unideb.inf.repository.CarRepository;
import hu.unideb.inf.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<CarDto> getCarList() {
        return carRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    @Override
    public void createCar(CarDto carDto) {
        Car car = new Car(carDto.getCarBrand(), carDto.getCarType(), carDto.getCarColor());
        carRepository.save(car);
    }

    @Override
    public void updateCar(CarDto carDto) {
        Optional<Car> car = carRepository.findById(carDto.getId());

        if (car.isPresent()) {
            Car toUpdate = car.get();
            toUpdate.setCarBrand(carDto.getCarBrand());
            toUpdate.setCarType(carDto.getCarType());
            toUpdate.setCarColor(carDto.getCarColor());
            carRepository.save(toUpdate);
        }
    }

    @Override
    public void deleteCar(CarDto carDto) {
        carRepository.deleteByCarBrandAndCarTypeAndCarColor(carDto.getCarBrand(), carDto.getCarType(), carDto.getCarColor());
    }

    private CarDto convertEntityToDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .carBrand(car.getCarBrand())
                .carType(car.getCarType())
                .carColor(car.getCarColor())
                .build();
    }
}