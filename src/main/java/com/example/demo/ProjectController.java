package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Project2;
import com.example.demo.ProjectService;
@RestController

@RequestMapping("/ap")
public class ProjectController {
		@Autowired
		ProjectService service;
		@RequestMapping("/project")
		public String test() {
			return"test project controller";
		}
		@RequestMapping("/getProjects")
		List<Project2> listProjects(){
			List<Project2> prodlist=service.fetchProjectList();
			for(Project2 p:prodlist) {			
				System.out.println(p+"\n");
				return prodlist;
			}
			return prodlist;
		}
		@GetMapping(value="/getProject/{id}")
		public ResponseEntity<Project2> findone(@PathVariable(value="id") Integer proid){
			Project2 prod=service.fetchProjectById( proid);
		if(prod!=null) {
			return new ResponseEntity<>(prod,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(prod,HttpStatus.NOT_FOUND);
		}
		}
		@PostMapping("/project/save")
		public ResponseEntity<Project2> saveEmp(@RequestBody Project2 p){
			Project2 prod=p;
			service.saveProject(p);
			return new ResponseEntity<Project2>(prod,HttpStatus.OK);
			
		}
		@PutMapping("/update")
		public ResponseEntity<Project2> updateOne(@RequestBody Project2 p){
			service.updateProject( p,p.getProid());
			return new ResponseEntity<>(p,HttpStatus.OK);
			
		}
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Project2> deletebyid(@PathVariable(value="id") Integer proId){
			Project2 p=service.deleteProjectById(proId);
			return new ResponseEntity<Project2>(p,HttpStatus.OK);
	}}
	

