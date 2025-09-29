package com.vehiclesSystem.dao;

import com.vehiclesSystem.models.Vehicle;

import java.sql.SQLException;

public interface VehicleDao {
    void saveVehicle(Vehicle vehicle) throws SQLException;
    void deleteVehicle(String id) throws SQLException;
    Vehicle updateVehicle(String id,String newBrand) throws SQLException;
    Vehicle searchById(String id) throws SQLException;
    Vehicle [] getAllVehicles();

}
