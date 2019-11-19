package com.example.service;

import java.util.List;

import com.example.model.Student;

public interface DBService {
	List<Student> getAll();
	void insertDB(String name, String addr, String dmX, String dmY);
}
