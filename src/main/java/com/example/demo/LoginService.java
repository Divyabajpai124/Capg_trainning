package com.example.demo;

import java.util.List;

public interface LoginService {
	void saveLogin(Login l);
	 Login  update(Login l ,String username);
	 List<Login> findByusername(String username);
	 Login findByuserpassword(String userpassword);

}
