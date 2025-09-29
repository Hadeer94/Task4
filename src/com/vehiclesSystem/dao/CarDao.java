package com.vehiclesSystem.dao;

import com.vehiclesSystem.models.Car;
import com.vehiclesSystem.models.Type;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class CarDao implements VehicleDao {

    @Autowired
    public DatabaseOperations databaseOperations;

    @Override
    public void saveVehicle(Vehicle vehicle) throws SQLException {

        databaseOperations.save(vehicle);
    }

    @Override
    public void deleteVehicle(String id) throws SQLException {
        databaseOperations.delete(id);
    }

    @Override
    public Vehicle updateVehicle(String id) throws SQLException {

        Car car = (Car) databaseOperations.update(id);
        return car;
    }

    @Override
    public Vehicle searchById(String id) throws SQLException {
        Car car = (Car)databaseOperations.searchById(id);
        return car;
    }

    @Override
    public Vehicle[] getAllVehicles() {
        return new Vehicle[0];
    }
}
