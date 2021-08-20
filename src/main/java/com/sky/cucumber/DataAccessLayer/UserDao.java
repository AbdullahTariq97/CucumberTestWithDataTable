package com.sky.cucumber.DataAccessLayer;

import com.sky.cucumber.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
    List<User> findByEmail(String email);

}
