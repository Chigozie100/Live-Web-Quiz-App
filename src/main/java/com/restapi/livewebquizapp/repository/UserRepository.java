package com.restapi.livewebquizapp.repository;

import com.restapi.livewebquizapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
}
