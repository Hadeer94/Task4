package com.vehiclesSystem.models;

import lombok.Setter;

public interface Vehicle {

     int  getId();
     String getBrand();
     Type getType();
     void setId(int id);
     void setBrand(String brand);
}
