package com.restapi.livewebquizapp.repository;

import com.restapi.livewebquizapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
