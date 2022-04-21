package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface loginRepo extends JpaRepository<Login,Integer> {

	Login getByUsername(String username);

	Login getByUserpassword(String userpassword);

}
