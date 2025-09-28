package com.vehiclesSystem.models;

import com.vehiclesSystem.dao.DatabaseOperations;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@Scope("prototype")
@ToString
public class Plane implements Vehicle{
    private int id;
    private String brand;
    private Type type;
    public DatabaseOperations databaseOperations;

    @Override
    public Type getType(){
        return type;
    }
    @Override
    public String getBrand(){
        return brand;
    }
    @Override
    public int getId(){
        return id;
    }

}
