package hu.unideb.inf.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class CarDto {

    private String carBrand;
    private String carType;
}