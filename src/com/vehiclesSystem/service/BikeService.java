package com.vehiclesSystem.service;

import com.vehiclesSystem.dao.BikeDao;
import com.vehiclesSystem.dao.CarDao;
import com.vehiclesSystem.models.Bike;
import com.vehiclesSystem.models.Car;
import com.vehiclesSystem.models.Type;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class BikeService {
    @Autowired
    BikeDao bikeDao;
    public void saveBike(Bike bike) throws SQLException {
        bikeDao.saveVehicle(bike);
    }
    public void deleteBike(String id ) throws SQLException {
        bikeDao.deleteVehicle(id);
    }
    public Vehicle searchByID(String id) throws SQLException {
        Bike bike = (Bike)bikeDao.searchById(id);
        return bike;
    }
    public Vehicle updateVehicle(String id,String newBrand) throws SQLException {
        Bike bike = (Bike) bikeDao.updateVehicle(id,newBrand);
        return bike;
    }
}
