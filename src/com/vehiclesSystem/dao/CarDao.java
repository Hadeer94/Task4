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
    public void deleteVehicle(int id) throws SQLException {
        databaseOperations.delete(id, Type.Car.toString());
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {

    }

    @Override
    public Vehicle searchById(int id) throws SQLException {
        Car car = (Car)databaseOperations.searchById(id,Type.Car.toString());
        return car;
    }

    @Override
    public Vehicle[] getAllVehicles() {
        return new Vehicle[0];
    }
}
