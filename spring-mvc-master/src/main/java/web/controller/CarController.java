package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String Cars(@RequestParam(value = "count", required = false) String count, ModelMap model) {
        List<Car> cars = new ArrayList<>();
        List<Car> carsToShow = new ArrayList<>();

        cars.add(new Car("bmw", "black", 111));
        cars.add(new Car("audi", "white", 222));
        cars.add(new Car("jaguar", "red", 333));
        cars.add(new Car("bentley", "green", 444));
        cars.add(new Car("honda", "blue", 555));
        cars.add(new Car("chevrolet", "gray", 666));
        cars.add(new Car("chrysler", "yellow", 777));

        int n = cars.size();
        if (count != null && Integer.parseInt(count) < 5) {
            n = Integer.parseInt(count);
        }
        for (int i = 0; i < n; i++) {
            carsToShow.add(cars.get(i));
        }

        CarService carService = new CarServiceImpl();
        model.addAttribute("messages", carsToShow);
        model.addAttribute("carCount", carService.carCount(carsToShow));
        return "cars";
    }

}