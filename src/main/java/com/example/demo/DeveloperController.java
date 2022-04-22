package com.example.demo;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.example.demo.Developer;
import com.example.demo.DeveloperService;
import com.example.demo.ProjectService;
import com.example.demo.Skill;
import com.example.demo.SkillService;
@RestController

@RequestMapping("/app")
@Controller
public class DeveloperController {
	@Autowired
	DeveloperService repository;
@Autowired 
SkillService ser;
@Autowired
ProjectService service;
	@RequestMapping("/project_test")
	public String test() {
		return"test project controller";
	}

	@RequestMapping("/getdevloper")
	List<Developer> listDeveloper(){
		List<Developer> prodlist=repository.fetchdevList();
		for(Developer p:prodlist) {
			System.out.println(p+"\n");
			return prodlist;
		}
		return prodlist;
	}


	@GetMapping("/sort")
	List<Developer> listDeveloperSortedSalary() throws Exception{
		try {
			List<Developer> dev=repository.Sortbyexp();
			
		for(Developer d:dev)
			System.out.println(d+"\n");
		return dev;
		
	}catch(InternalServerError ex) {
		throw new Exception("INTERNAL_SERVER_ERROR");
	}


	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Developer> deletebyid(@PathVariable(value="id") Integer id){
		Developer p=repository.deletedevloperById(id);
		return new ResponseEntity<Developer>(p,HttpStatus.OK);
}
	@PutMapping("/update")
	public ResponseEntity<Developer> updateOne(@RequestBody Developer p){
		repository.updatedevloper(p, p.getId());
		return new ResponseEntity<>(p,HttpStatus.OK);
		
	}
	@RequestMapping("/getSkill")
	List<Skill> listSkill(){
		List<Skill> list=ser.fetchskillList();
		for(Skill p:list) {
			System.out.println(p+"\n");
			return list;
		}
		return list;
	}


	
}
	
