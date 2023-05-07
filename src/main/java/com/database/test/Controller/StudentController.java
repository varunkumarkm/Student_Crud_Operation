package com.database.test.Controller;

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
import com.database.test.Entities.Student;
import com.database.test.Entities.StudentDTO;
import com.database.test.Services.StudentService;

@RestController
@RequestMapping("/Student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/createStudent")
	public ResponseEntity<StudentDTO> createStudent(@RequestBody Student student) {
		
		StudentDTO studentDTO = new StudentDTO();
		
		studentDTO.setId(student.getId());
		studentDTO.setFirstName(student.getFirstName());
		studentDTO.setLastName(student.getLastName());
		studentDTO.setAddress(student.getAddress());
		studentDTO.setCourse(student.getCourse());
		
		studentService.save(student);
		
		return new ResponseEntity<StudentDTO>(studentDTO,HttpStatus.ACCEPTED);
	}
	@GetMapping("/getStudents")
	public List<Student> getStudents(Student student){
		List<Student> students = studentService.getStudents();
		return students;
	}
	@PutMapping("/updateStudent")
	public ResponseEntity<StudentDTO> putStudent(@RequestBody Student student) {
		
        StudentDTO studentDTO = new StudentDTO();
		
		studentDTO.setId(student.getId());
		studentDTO.setFirstName(student.getFirstName());
		studentDTO.setLastName(student.getLastName());
		studentDTO.setAddress(student.getAddress());
		studentDTO.setCourse(student.getCourse());
		
		studentService.save(student);
		return new ResponseEntity<StudentDTO>(studentDTO,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable long id) {
		studentService.deleteById(id);
	}
}