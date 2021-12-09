package com.test.service;

import com.test.exceptions.NotFoundException;
import com.test.model.Phone;
import com.test.model.User;
import com.test.repository.PhoneRepository;
import com.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneServiceImpl implements PhoneService{

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public List<Phone> getAll() {
        return phoneRepository.findAll();
    }

    @Override
    public void save(Phone phone) {
        phoneRepository.save(phone);
    }

    @Override
    public void update(int id, int number) throws NotFoundException {
        //UserServiceImpl userService = new UserServiceImpl();
        //User u = userService.getById(id);

        Optional<Phone> optionalUser = phoneRepository.findById(Integer.valueOf(id));
        Phone phone = optionalUser.get();
        phone.setNumber(number);
        phoneRepository.save(phone);
    }

    @Override
    public void delete(int id) {
        phoneRepository.deleteById(Integer.valueOf(id));
    }

    @Override
    public Phone getById(int id) throws NotFoundException {
        Optional<Phone> optionalPhone = phoneRepository.findById(Integer.valueOf(id));
        if (!optionalPhone.isPresent()) {
            throw new NotFoundException("Not found!");
        }
        return optionalPhone.get();
    }
}
