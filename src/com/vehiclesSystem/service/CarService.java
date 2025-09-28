package com.vehiclesSystem.service;

import com.vehiclesSystem.dao.CarDao;
import com.vehiclesSystem.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class CarService {
    @Autowired
    public CarDao carDao;
    public void saveCar(Car car) throws SQLException {
        carDao.saveVehicle(car);

    }
}
