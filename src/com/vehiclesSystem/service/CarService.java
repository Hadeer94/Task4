package com.vehiclesSystem.service;

import com.vehiclesSystem.dao.CarDao;
import com.vehiclesSystem.models.Car;
import com.vehiclesSystem.models.Type;
import com.vehiclesSystem.models.Vehicle;
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
    public void deleteCar(int id ) throws SQLException {
        carDao.deleteVehicle(id);
    }
    public Vehicle searchByID(int id) throws SQLException {
        Car car = (Car)carDao.searchById(id);
        return car;
    }
}
