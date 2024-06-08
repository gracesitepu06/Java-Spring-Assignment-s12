package id.address.spring_data_assigment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import id.address.spring_data_assigment.entity.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long>{

    List<User> findByName(String name);
}