package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.DBMapper;
import com.example.model.Student;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DBServieImpl implements DBService {
	
	@Autowired
	private DBMapper service;

	@Override
	public List<Student> getAll() {
		return service.getAll();
	}

	@Override
	public void insertDB(String name, String addr, String dmX, String dmY) {
		service.insertDB( name, addr, dmX, dmY);
	}

}
