package hu.unideb.inf.controller;

import hu.unideb.inf.model.CarDto;
import hu.unideb.inf.service.CarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller("carController")
@SessionScope
public class CarController {

    @Autowired
    private CarService carService;

    private CarDto carDto;
    private List<CarDto> carDtoList;
    private boolean isUpdateDisabled = true;


    @PostConstruct
    public void listCars() {
        if (!getCarDtoList().isEmpty()) {
            getCarDtoList().clear();
        }
        getCarDtoList().addAll(carService.getCarList());
    }

    public void saveCar() {
        carService.createCar(this.getCarDto());
        listCars();
    }

    public void copyFieldsToInput(CarDto carDto) {
        BeanUtils.copyProperties(carDto, getCarDto());
        isUpdateDisabled = false;
    }

    public void editCar() {
        carService.updateCar(this.getCarDto());
        isUpdateDisabled = true;
        listCars();
    }

    public void removeCar(CarDto carDto) {
        carService.deleteCar(carDto);
        listCars();
    }

    public CarDto getCarDto() {
        if (carDto == null) {
            carDto = new CarDto();
        }
        return carDto;
    }

    public void setCarDto(CarDto carDto) {
        this.carDto = carDto;
    }

    public List<CarDto> getCarDtoList() {
        if (carDtoList == null) {
            carDtoList = new ArrayList<>();
        }
        return carDtoList;
    }

    public boolean getIsUpdateDisabled() {
        return isUpdateDisabled;
    }
}