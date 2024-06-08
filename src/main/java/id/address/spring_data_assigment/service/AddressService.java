package id.address.spring_data_assigment.service;

import id.address.spring_data_assigment.entity.Address;
import id.address.spring_data_assigment.entity.User;
import id.address.spring_data_assigment.repository.AddressRepository;
import id.address.spring_data_assigment.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address addAddress(Address address, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        address.setUser(user);
        return addressRepository.save(address);
    }

    public List<Address> findByCity(String city) {
        return addressRepository.findByCity(city);
    }

    public List<Address> findByCountry(String country) {
        return addressRepository.findByCountry(country);
    }
}
