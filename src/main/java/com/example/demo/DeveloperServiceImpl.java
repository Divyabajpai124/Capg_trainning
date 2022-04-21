package com.example.demo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DeveloperServiceImpl implements DeveloperService {
	@Autowired
	DeveloperRepository repo;

	@Override
	public Developer saveDev(Developer d) {
		repo.save(d);
		return d;
	}	

	

	@Override
	public Developer updatedevloper(Developer d, int id) {
		Developer d1=repo.getById(id);
		d1.setFirstname(d.getFirstname());
		d1.setLastname(d.getLastname());
		d1.setEmail(d.getEmail());
		d1.setExp(d.getExp());
		repo.save(d1);
		return d1;
		}
	@Override
	public Developer deletedevloperById(int id) {
	repo.deleteById(id);
	return null;
	}
	
	@Override
	public List<Developer> fetchdevList() {
		List<Developer> d=repo.findAll();
		
		// TODO Auto-generated method stub
		return d;
	}
	

	@Override
	public List<Developer> Sortbyexp(){
		List<Developer> d=repo.findAll();
		return d.stream().sorted(Comparator.comparingInt(Developer::getExp).reversed()).collect(Collectors.toList());
	}



	@Override
	public Developer findById(Integer id) {
		Developer d=repo.getById(id);
		// TODO Auto-generated method stub
		return d;
	}






	
}	
	
		



