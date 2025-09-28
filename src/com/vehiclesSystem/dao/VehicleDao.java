package com.vehiclesSystem.dao;

import com.vehiclesSystem.models.Vehicle;

import java.sql.SQLException;

public interface VehicleDao {
    public void saveVehicle(Vehicle vehicle) throws SQLException;
}
