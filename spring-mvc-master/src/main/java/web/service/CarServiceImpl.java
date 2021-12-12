package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    @Override
    public int carCount(List<Car> cars) {
        return cars.size();
    }

/*    @Override
    public void addCar(String model, String color, int series){

    }*/
}
