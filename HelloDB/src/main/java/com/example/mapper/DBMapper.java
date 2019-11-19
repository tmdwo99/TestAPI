package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Student;

@Mapper
@Repository
public interface DBMapper {
	List<Student> getAll();
	void insertDB(@Param("name") String name,@Param("addr") String addr,@Param("dmX") String dmX,@Param("dmY") String dmY);
}
