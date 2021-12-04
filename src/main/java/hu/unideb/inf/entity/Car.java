package hu.unideb.inf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "CAR_DATA")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "CAR_BRAND", nullable = false)
    private String carBrand;
    @Column(name = "CAR_TYPE", nullable = false)
    private String carType;

    public Car(String carBrand, String carType) {
        this.carBrand = carBrand;
        this.carType = carType;
    }
}
