package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProjectServiceImpl implements ProjectService{
	@Autowired
	ProjectRepository pro;
	
	@Override

	public Project2 saveProject(Project2 p) {
		pro.save(p);
		return p;
	}
	public List<Project2> fetchProjectList(){
		List<Project2> list=pro.findAll();
		return list;
	}

@SuppressWarnings("static-access")
@Override

public Project2 updateProject(Project2 p, int proid) {
Project2 p1=pro.getById(proid);
p1.setPname(p.getPname());
p1.setStrtdate(p.getStrtdate());
p1.setEndate(p.getEndate());
pro.save(p1);
return p1;
}
@Override
public Project2 deleteProjectById(int proid) {
pro.deleteById(proid);
return null;

	}


public Project2 fetchProjectById(int proid) {
	
	Project2 p=pro.getById(proid);
return p;
		
	}
}

