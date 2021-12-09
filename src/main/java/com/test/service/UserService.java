package com.test.service;

import com.test.exceptions.BadRequestException;
import com.test.exceptions.NotFoundException;
import com.test.model.User;

import javax.mail.MessagingException;
import java.util.List;

public interface UserService {

    List<User> getAll();

    void save(User user) throws NotFoundException;

    void update(int id, String name) throws NotFoundException;

    void delete(int id);

    User getById(int id) throws NotFoundException;


    User findByEmail(String email) throws NotFoundException;

    User getByName(String name);

    void verified(String email);

    User login(String email, String password) throws BadRequestException;

    void resetPassword(String resetPasswordToken, String newPassword) throws BadRequestException;

    String takeToken(String email);

    void sendEmail(String to, String subject, String text) throws NotFoundException, MessagingException;
}
