package com.test.service;

import com.test.exceptions.NotFoundException;
import com.test.model.Address;
import com.test.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void update(int id, String number) throws NotFoundException {
        //UserServiceImpl userService = new UserServiceImpl();
        //User u = userService.getById(id);

        Optional<Address> optionalAddress = addressRepository.findById(Integer.valueOf(id));
        Address address = optionalAddress.get();
        address.setNumber(number);
        addressRepository.save(address);
    }

    @Override
    public void delete(int id) {
        addressRepository.deleteById(Integer.valueOf(id));
    }

    @Override
    public Address getById(int id) throws NotFoundException {
        Optional<Address> optionalAddress = addressRepository.findById(Integer.valueOf(id));
        if (!optionalAddress.isPresent()) {
            throw new NotFoundException("Not found!");
        }
        return optionalAddress.get();
    }
}
