package com.example.demo;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class LoginSerImpl implements LoginService {
	@Autowired
	loginRepo repo;
	
	@Override
	public void saveLogin(Login l) {
		repo.save(l);
	}
	
	@Override
	public Login  update(Login l ,String username) {
		Login l1=repo.getByUsername(username);
		l1.setUserpassword(l.getUserpassword());
		repo.save(l1);
	    return l1;
	
	}
	
	@Override
	public List<Login> findByusername(String username) {
		List<Login> u= repo.findAll();
		u=u.stream().filter(s->s.getUsername().contains(username)).collect(Collectors.toList());
	return u;
	}
	public Login findByuserpassword(String userpassword) {
		Login u= repo.getByUserpassword(userpassword);
		return u;
	}

	
}
