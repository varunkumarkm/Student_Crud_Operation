package com.database.test.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.test.Entities.Student;
import com.database.test.Entities.StudentDTO;
import com.database.test.Repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	public List<Student> getStudents(){
		List<Student> findAllStudents = studentRepo.findAll();
		return findAllStudents;
	}
	
	public void deleteById(long id) {
		studentRepo.deleteById(id);
		
	}
	public void save(Student student) {
		studentRepo.save(student);		
	}
}
