package org.nefure.goodshops;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author nefure
 */
@SpringBootApplication
@MapperScan(basePackages = "org.nefure.goodshops.mapper")
public class GoodShopsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodShopsApplication.class, args);
    }

}
