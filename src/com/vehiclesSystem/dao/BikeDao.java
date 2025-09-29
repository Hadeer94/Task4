package com.vehiclesSystem.dao;

import com.vehiclesSystem.models.Vehicle;

import java.sql.SQLException;

public class BikeDao implements VehicleDao {
    @Override
    public void saveVehicle(Vehicle vehicle) throws SQLException {

    }

    @Override
    public void deleteVehicle(String id) throws SQLException {

    }

    @Override
    public Vehicle updateVehicle(String id) throws SQLException {
        return null;
    }

    @Override
    public Vehicle searchById(String id) throws SQLException {
        return null;
    }

    @Override
    public Vehicle[] getAllVehicles() {
        return new Vehicle[0];
    }
}
