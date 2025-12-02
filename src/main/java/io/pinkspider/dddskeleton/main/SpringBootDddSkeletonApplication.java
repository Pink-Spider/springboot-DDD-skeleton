package io.pinkspider.dddskeleton.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.pinkspider.dddskeleton")
public class SpringBootDddSkeletonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDddSkeletonApplication.class, args);
    }

}
