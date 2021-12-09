package com.test.controller;

import com.test.exceptions.BadRequestException;
import com.test.exceptions.NotFoundException;
import com.test.model.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("{id}")
    @RolesAllowed(value = "ROLE_ADMIN")
    User getById(@PathVariable int id) throws NotFoundException {
        return userService.getById(id);
    }

    @RequestMapping("/get-by-email")
    @GetMapping
    User getByEmail(@RequestParam("email") String email) throws NotFoundException {
        return userService.findByEmail(email);
    }

    @DeleteMapping("/delete/{i}")
    void deleteById(@PathVariable int i) {
        userService.delete(i);
    }

    @PatchMapping("/{id}/{name}")
    void update( @PathVariable("id") int id,@PathVariable("name") String name) throws NotFoundException {
        userService.update(id, name);
    }

    @PostMapping
    @RequestMapping("/save")
    public void create(@RequestBody User user) throws NotFoundException, MessagingException {
        userService.save(user);
        userService.sendEmail(user.getEmail(), "You must confirm", "<a href=\"http://localhost:8080/user/verified?email=" + user.getEmail()  + "\">VERIFY</a>");
    }

    @PostMapping
    @RequestMapping("/resetPassword")
    void resetPassword(@RequestParam("token") String token, @RequestParam("newPassword") String newPassword) throws BadRequestException {
        userService.resetPassword(token, newPassword);
    }

    @RequestMapping("/login")
    @PostMapping
    void login(@RequestParam("name") String email,@RequestParam("password") String password) throws BadRequestException {
        userService.login(email,password);
    }

    @GetMapping
    @RequestMapping("/verified")
    void verified(@RequestParam("email") String email) {
        userService.verified(email);
    }

    @PostMapping
    @RequestMapping("/takeToken")
    void takeToken(@RequestParam("mail") String email) throws NotFoundException, MessagingException {
        userService.sendEmail(email, "reset password", userService.takeToken(email));
    }

    /*@GetMapping
    @RequestMapping("/message")
    void sendEmail(*//*@RequestParam("to")String to,@RequestParam("email") String subject,@RequestParam("text") String text*//*) throws NotFoundException, MessagingException {
        String text = "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"google.com\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Your company name.";
        userService.sendEmail("gor.aleksanyan.2004@mail.ru", "You must confirm", text);


    }*/
}
