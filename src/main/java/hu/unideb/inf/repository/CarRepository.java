package hu.unideb.inf.repository;

import hu.unideb.inf.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    Optional<Car> findByCarBrandAndCarType(String carBrand, String carType);

    void deleteCarByCarBrandAndCarType(String carBrand, String carType);
}
