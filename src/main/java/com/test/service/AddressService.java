package com.test.service;

import com.test.exceptions.NotFoundException;
import com.test.model.Address;
import com.test.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AddressService {
    List<Address> getAll();

    void save(Address address);

    void update(int id, String number) throws NotFoundException;

    void delete(int id);

    Address getById(int id) throws NotFoundException;
}
