package id.address.spring_data_assigment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.address.spring_data_assigment.entity.Address;
import java.util.List;


public interface AddressRepository extends JpaRepository<Address, Long>{
    
    List<Address> findByCity(String city);
    List<Address> findByCountry(String country);
    
}
