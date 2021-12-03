package hu.unideb.inf.controller;

import hu.unideb.inf.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

@Controller("carController")
@SessionScope
public class CarController {

    @Autowired
    private CarService carService;
}
