package com.navinda.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.navinda.sms.model.Student;
import com.navinda.sms.service.StudentService;

@RestController
@RequestMapping(value="/smscloud")
public class Controller {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/student", method= RequestMethod.POST)
	public Student saveStudent(@RequestBody Student student) {
		return studentService.save(student);
	}
	
	@RequestMapping(value="/student",method=RequestMethod.GET)
	public List<Student> fetch(){
		return studentService.fetch();
	}
	
	@RequestMapping(value="/student/{id}",method=RequestMethod.GET)
	public ResponseEntity<Student> fetch(@PathVariable Integer id){
		if(id<=0) {
			return ResponseEntity.badRequest().build();
		}else {
			Student student = studentService.fetch(id);
			if(student==null) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(student);
			}
		}
	}
	
	
	
	
	
	


}
