package com.test.controller;

import com.test.exceptions.NotFoundException;
import com.test.model.Phone;
import com.test.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping
    List<Phone> getAll() {
        return phoneService.getAll();
    }

    @GetMapping("{id}")
    Phone getById(@PathVariable int id) throws NotFoundException {
        return phoneService.getById(id);
    }

    @DeleteMapping("/{i}")
    void deleteById(@PathVariable int i) {
        phoneService.delete(i);
    }

    @PatchMapping("/{id}/{number}")
    void update( @PathVariable("id") int id,@PathVariable("number") int number) throws NotFoundException {
        phoneService.update(id, number);
    }

    @PostMapping
    public void create(@RequestBody Phone phone){
        phoneService.save(phone);
    }
}
