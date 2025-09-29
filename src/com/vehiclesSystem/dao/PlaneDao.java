package com.vehiclesSystem.dao;

import com.vehiclesSystem.models.Plane;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class PlaneDao implements VehicleDao{
    public DatabaseOperations databaseOperations;

    @Autowired
    public void setDatabaseOperations(DatabaseOperations databaseOperations){
        this.databaseOperations = databaseOperations;
    }

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
        Plane plane =(Plane)databaseOperations.update(id,newBrand);
        return plane;
    }

    @Override
    public Vehicle searchById(String id) throws SQLException {
        Plane plane =(Plane)databaseOperations.searchById(id);
        return plane;
    }

    @Override
    public Vehicle[] getAllVehicles() {
        return new Vehicle[0];
    }
}
