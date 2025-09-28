package com.vehiclesSystem.dao;

import com.vehiclesSystem.models.Vehicle;
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

    @PostConstruct
    public void connectToDatabase () throws SQLException {
        System.out.println("connect to database established ");
        connection = DriverManager.getConnection(
                url,userName,password);

    }
    @PreDestroy
    public void disconnectFromDatabase(){
        System.out.println("connect to database closed");
    }
    public void save(Vehicle vehicle) throws SQLException {
        String sql = "INSERT INTO car (id, brand, type) VALUES (?, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, vehicle.getId());
        preparedStatement.setString(2, vehicle.getBrand());
        preparedStatement.setString(3, vehicle.getType().toString());

        int rowsInserted = preparedStatement.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("A new car saved");
        }

    }
    public void delete(Vehicle vehicle){

    }
    public void update(){

    }
    public void searchById(){

    }
    public void getAllVehicles(){

    }
}
