package com.vehiclesSystem;

import com.vehiclesSystem.config.Config;
import com.vehiclesSystem.controller.CarController;
import com.vehiclesSystem.models.Bike;
import com.vehiclesSystem.models.Car;
import com.vehiclesSystem.models.Type;
import com.vehiclesSystem.service.BikeService;
import com.vehiclesSystem.service.CarService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        CarService carService = (CarService) context.getBean("carService");
        //carService.saveCar(new Car("2","c",Type.CAR));
        //carService.deleteCar(1);
        //Car car = (Car)carService.searchByID(1);
//        //System.out.println("Id "+car.getId()+" Brand "+car.getBrand()+" Type "+car.getType());
//        Car car= (Car)carService.updateVehicle("1","newBrand");
//        System.out.println("Id "+car.getId()+" Brand "+car.getBrand()+" Type "+car.getType());
//        BikeService bikeService = (BikeService) context.getBean("bikeService");
//        bikeService.saveBike(new Bike("3","b",Type.BIKE));
        ((AnnotationConfigApplicationContext)context).close();


    }

}
