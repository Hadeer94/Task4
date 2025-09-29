package com.vehiclesSystem.dao;

import com.vehiclesSystem.models.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.*;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Component
public class DatabaseOperations {
    @Value("${database.url}")
    private String url;
    @Value("${database.username}")
    private String userName;
    @Value("${database.password}")
    private String password;
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    String sql;

    @PostConstruct
    public void connectToDatabase () throws SQLException {
        System.out.println("connect to database established ");
        connection = DriverManager.getConnection(
                url,userName,password);

    }
    @PreDestroy
    public void disconnectFromDatabase() throws SQLException {
        connection.close();
        System.out.println("connect to database closed");
    }
    public void save(Vehicle vehicle) throws SQLException {
        String sql = "insert into vehicle (id, brand,type) values (?, ?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, vehicle.getId());
        preparedStatement.setString(2, vehicle.getBrand());
        preparedStatement.setString(3, vehicle.getType().toString());

        int rowsInserted = preparedStatement.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("A new vehicle saved");
        }

    }
    public void delete(String id)throws SQLException{

        if(searchById(id)!=null){
            sql = "delete from vehicle where id =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("vehicle"+ id+" deleted");
            }
        }
        else{
            System.out.println("vehicle  "+id+" not found to delete it ");
        }

    }
    public Vehicle update(String id,String newBrand) throws SQLException {
        Vehicle vehicle = searchById(id);
        if(vehicle!=null){
            sql = "update vehicle set brand=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newBrand);
            preparedStatement.setString(2, id);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                vehicle.setBrand(newBrand);
                return vehicle;
            }
        }
        return null;
    }
    public Vehicle searchById(String id) throws SQLException {
        sql = "select* from vehicle where id=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,id);
        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()) {
            String type = rs.getString("type");
            String vehicleId = rs.getString("id");
            String brand = rs.getString("brand");
            switch (type) {
                case "Car":
                    return new Car(vehicleId, brand, Type.CAR);
                case "Bike":
                    return new Bike(vehicleId, brand, Type.BIKE);
                case "Plane":
                    return new Plane(vehicleId, brand, Type.PLANE);
                default:
                    throw new IllegalArgumentException("Unknown vehicle type: " + type);
            }

        }
        System.out.println("not found");
        return null;
    }
    public void getAllVehicles(String type) throws SQLException {
        sql = "select * from vehicle where type=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,type);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()){

        }
    }
}
