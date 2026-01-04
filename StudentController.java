package com.StudentManagementSystem.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.StudentManagementSystem.Entity.Student;
import com.StudentManagementSystem.Service.StudentService;


@org.springframework.stereotype.Controller
public class StudentController {

	
	@Autowired
	StudentService studentService;

	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("Students", studentService.getAllStudents());
		
		return "Students";
	}
	
	
	@GetMapping("/student/new")
	public String createStudentFrom(Model model) {
		Student student = new Student();
		model.addAttribute("Students", student);
		
		return "createstudent";
	}
	
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student")Student student) {
		studentService.saveStudent(student);
		
		return "redirect:/students";
	}
	
	
	@GetMapping("/students/update/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
		
		model.addAttribute("student", studentService.getById(id));
		
		return "updatestudent";
	}
	
	
	@PostMapping("/students/update/{id}")
	public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student) {
		
		Student existingStudent = studentService.getById(id);
		
		existingStudent.setFirstname(student.getFirstname());
		existingStudent.setLastname(student.getLastname());
		existingStudent.setEmail(student.getEmail());
		
		studentService.saveStudent(existingStudent);
		
		return "redirect:/students";
	}
	
	
	@GetMapping("/students/{id}")
	public String deleteById(@PathVariable int id) {
		
		studentService.deleteById(id);
		
		return "redirect:/students";
	}
	

}
