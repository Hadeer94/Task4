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
public class Bike implements Vehicle{
    private String id;
    private String brand;
    private Type type;

    public Bike(String id, String brand, Type type) {
        this.id = id;
        this.brand = brand;
        this.type = type;
    }

    @Override
    public Type getType(){
        return type;
    }
    @Override
    public String getBrand(){
        return brand;
    }
    @Override
    public String getId(){
        return id;
    }
    @Override
    public void setId(String id){
        this.id = id;
    }
    @Override
    public void setBrand(String brand){
        this.brand = brand;
    }
}
