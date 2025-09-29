package com.vehiclesSystem.dao;

import com.vehiclesSystem.models.Vehicle;

import java.sql.SQLException;

public interface VehicleDao {
    void saveVehicle(Vehicle vehicle) throws SQLException;
    void deleteVehicle(int id) throws SQLException;
    void updateVehicle(Vehicle vehicle);
    Vehicle searchById(int id) throws SQLException;
    Vehicle [] getAllVehicles();

}
