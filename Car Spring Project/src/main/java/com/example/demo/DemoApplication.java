package com.example.demo;

import com.example.demo.Domain.CarInfo;
import com.example.demo.Domain.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CarRepository repository) {
        return args -> {
            repository.save(new CarInfo("Honda", "Accord", 2003, "red", true));
            repository.save(new CarInfo("Ford", "F150", 2013, "grey", true));
            repository.save(new CarInfo("Land Rover", "Range Rover", 2019, "black", false));
            repository.save(new CarInfo("BMW", "X Series", 2019, "white", false));
            repository.save(new CarInfo("Lexus", "RX300", 1999, "silver", true));
            repository.save(new CarInfo("Ford", "Explorer", 2017, "grey", true));


            log.info("Cars found with findAll(): ");
            log.info("--------------------------------");
            for(CarInfo customer: repository.findAll()){
                log.info(customer.toString());
            }
            log.info("");

            log.info("Cars found with findByColor('Grey')");
            log.info("----------------------------------------");
            for (CarInfo carInfo : repository.findByColor("grey")) {
                log.info(carInfo.toString());
            }
            log.info("");

            log.info("Cars found with findByMake('Lexus')");
            log.info("----------------------------------------");
            for (CarInfo x : repository.findByMake("Lexus")) {
                log.info(x.toString());
            }
            log.info("");

            log.info("New cars found with findAllByNew(true)");
            log.info("----------------------------------------");

            for (CarInfo x : repository.findByYear(2019)) {
                log.info(x.toString());
            }
            log.info("");

            log.info("Car found with findByModel('Accord')");
            log.info("----------------------------------------");
            repository.findByModel("Accord").forEach(x -> {
                log.info(x.toString());
            });
        };
    }

}
