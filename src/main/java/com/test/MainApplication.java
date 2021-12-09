package com.test;

import com.test.exceptions.BadRequestException;
import com.test.exceptions.NotFoundException;
import com.test.model.User;
import com.test.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        //ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);
        /*User user = new User();
        user.setEmail("dsa");
        user.setId(2);
        user.setName("Gor");
        user.setPassword("asdfg");*/
        //UserService userService = (UserService) context.getBean("userServiceImpl");
        /*try {
            System.out.println(userService.login("Game", "123789"));
        } catch (BadRequestException e) {
            e.printStackTrace();
        }*/
        /*System.out.println(userService.getByName("Game"));*/
        /*try {
            userService.update(2, "Ara");
        } catch (NotFoundException e) {
            e.printStackTrace();
        }*/

        /*try {
            System.out.println(userService.getById(2));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }*/

    }
}