package com.vehiclesSystem.dao;

import com.vehiclesSystem.models.Bike;
import com.vehiclesSystem.models.Car;
import com.vehiclesSystem.models.Plane;
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
    String sql;

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
        String tableName = vehicle.getType().toString().toLowerCase();
        String sql = "insert into " + tableName + " (id, brand) values (?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, vehicle.getId());
        preparedStatement.setString(2, vehicle.getBrand());

        int rowsInserted = preparedStatement.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("A new "+tableName+" saved");
        }

    }
    public void delete(int id,String type )throws SQLException{
        String tableName = type.toLowerCase();
        if(searchById(id,tableName)!=null){
            sql = "delete from "+ tableName+ " where id =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("A  "+tableName+" deleted");
            }
        }
        else{
            System.out.println(tableName+" with "+id+" not found to delete it ");
        }

    }
    public void update(Vehicle vehicle) throws SQLException {
        sql = "update car set brand= ?,type= ? where id =?";

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, vehicle.getBrand());
        preparedStatement.setString(2, vehicle.getType().toString());
        preparedStatement.setInt(3, vehicle.getId());
    }
    public Vehicle searchById(int id,String tableName) throws SQLException {
        sql = "select* from "+tableName.toLowerCase()+" where id=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet rs = preparedStatement.executeQuery();
        Vehicle vehicle;
        if(rs.next()){
            System.out.println(tableName);
            switch (tableName){
                case "Car":
                    vehicle = new Car();
                    vehicle.setId(rs.getInt("id"));
                    vehicle.setBrand(rs.getString("brand"));
                    System.out.println("car est");
                    return vehicle;

                case "bike":
                    vehicle = new Bike();
                    vehicle.setId(rs.getInt("id"));
                    vehicle.setBrand(rs.getString("brand"));
                    return vehicle;
                case "plane":
                    vehicle = new Plane();
                    vehicle.setId(rs.getInt("id"));
                    vehicle.setBrand(rs.getString("brand"));
                    return vehicle;
            }

        }
        System.out.println("not found");
        return null;
    }
    public void getAllVehicles(){

    }
}
