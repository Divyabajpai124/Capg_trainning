package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ProjectService {

	Project2 saveProject(Project2 p);

	Project2 updateProject(Project2 p, int proid);

	Project2 deleteProjectById(int proid);
    Project2 fetchProjectById(int proid);
    List<Project2> fetchProjectList();
}
