package id.address.spring_data_assigment.controller;

import id.address.spring_data_assigment.entity.Address;
import id.address.spring_data_assigment.service.AddressService;
// import id.address.spring_data_assigment.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    // @Autowired
    // private UserService userService;

    @PostMapping
    public String addAddress(@RequestBody Address address, @RequestParam Long userId) {
        Address createdAddress = addressService.addAddress(address, userId);
        return "Berhasil menambahkan alamat untuk user: " + createdAddress.getUser().getName();
    }

    @GetMapping("/search/city")
    public List<Address> findByCity(@RequestParam String city) {
        return addressService.findByCity(city);
    }

    @GetMapping("/search/country")
    public List<Address> findByCountry(@RequestParam String country) {
        return addressService.findByCountry(country);
    }
}
