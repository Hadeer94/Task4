package com.vehiclesSystem.models;

import lombok.Setter;

public interface Vehicle {

     String  getId();
     String getBrand();
     Type getType();
     void setId(String id);
     void setBrand(String brand);
}
