package com.vehiclesSystem.dao;

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
}
