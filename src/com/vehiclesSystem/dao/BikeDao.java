package com.vehiclesSystem.dao;

import com.vehiclesSystem.models.Bike;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
@Component
public class BikeDao implements VehicleDao {
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
    public Vehicle updateVehicle(String id,String newBrand) throws SQLException {
        Bike bike = (Bike)databaseOperations.update(id,newBrand);
        return bike;
    }

    @Override
    public Vehicle searchById(String id) throws SQLException {
        Bike bike = (Bike) databaseOperations.searchById(id);
        return bike;
    }

    @Override
    public Vehicle[] getAllVehicles() {
        return new Vehicle[0];
    }
}
