package com.myRestApi;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myRestApi.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	
	private List<Student> theStudents;
	
	@PostConstruct
	public void loadData()
	{
    theStudents = new ArrayList<Student>();
    theStudents.add(new Student("shubham","anurag"));
    theStudents.add(new Student("shub","anu"));
    theStudents.add(new Student("tarun","gupta"));
	}
	@GetMapping("/students")
    public List<Student> getStudents()
    {
		

		return theStudents;
    }
	
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId)
	{
		if((studentId >= theStudents.size()) || (studentId < 0))
		{
			throw new StudentNotFoundException("Student id not found- "+ studentId);
		}
		return theStudents.get(studentId);
		
	}
	
}




















