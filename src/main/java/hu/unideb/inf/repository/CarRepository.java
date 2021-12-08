package hu.unideb.inf.repository;

import hu.unideb.inf.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    Optional<Car> findById(Integer id);

    @Transactional
    void deleteByCarBrandAndCarTypeAndCarColor(String carBrand, String carType, String carColor);
}
