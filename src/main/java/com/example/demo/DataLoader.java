package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CarRepository repository;

    @Override
    public void run(String...strings) throws Exception{
        Car car = new Car ("1980","Ford","1981") ;
        repository.save(car);

        car = new Car("1970","Toyota", "1971");
        repository.save(car);

        car = new Car("1960","Honda","1961");
        repository.save(car);


    }
}
