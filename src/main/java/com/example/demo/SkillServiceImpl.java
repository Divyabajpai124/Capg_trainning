package com.example.demo;

import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {
	@Autowired
	SkillRepository rep;
	@Override

	public List<Skill> fetchskillList() {
		List<Skill> d=rep.findAll();
		
		// TODO Auto-generated method stub
		return d;
	}


}
