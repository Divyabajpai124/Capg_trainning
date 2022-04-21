package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
@Service
public interface DeveloperService {
	Developer saveDev(Developer d);
	List<Developer> fetchdevList();

	Developer updatedevloper(Developer d, int id);

	Developer deletedevloperById(int id);

	List<Developer> Sortbyexp();
	Developer findById(Integer id);
	

	//Developer fetchbyId(int id);

	
}
