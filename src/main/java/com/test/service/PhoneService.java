package com.test.service;

import com.test.exceptions.NotFoundException;
import com.test.model.Phone;
import com.test.model.User;

import java.util.List;

public interface PhoneService {
    List<Phone> getAll();

    void save(Phone phone);

    void update(int id, int number) throws NotFoundException;

    void delete(int id);

    Phone getById(int id) throws NotFoundException;
}
