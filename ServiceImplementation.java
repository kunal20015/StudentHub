package com.StudentManagementSystem.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagementSystem.Entity.Student;
import com.StudentManagementSystem.Repository.StudentRepository;
import com.StudentManagementSystem.Service.StudentService;

@Service
public class ServiceImplementation implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public Student getById(int id) {
		
		return studentRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		
		studentRepository.deleteById(id);
	}

}
