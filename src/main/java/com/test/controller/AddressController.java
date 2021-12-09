
package com.test.controller;

import com.test.exceptions.NotFoundException;
import com.test.model.Address;
import com.test.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    List<Address> getAll() {
        return addressService.getAll();
    }

    @GetMapping("{id}")
    Address getById(@PathVariable int id) throws NotFoundException {
        return addressService.getById(id);
    }

    @DeleteMapping("/{i}")
    void deleteById(@PathVariable int i) {
        addressService.delete(i);
    }

    @PatchMapping("/{id}/{number}")
    void update( @PathVariable("id") int id,@PathVariable("number") String number) throws NotFoundException {
        addressService.update(id, number);
    }

    @PostMapping
    public void create(@RequestBody Address address){
        addressService.save(address);
    }
}
