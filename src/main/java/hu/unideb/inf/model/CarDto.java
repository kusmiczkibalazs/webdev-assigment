package hu.unideb.inf.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CarDto {

    private Integer id;
    private String carBrand;
    private String carType;
    private String carColor;
}