package com.navinda.sms.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navinda.sms.model.Student;
import com.navinda.sms.model.Telephone;
import com.navinda.sms.repository.Studentrepository;

@Service
public class StudentServiceImp implements StudentService{

	@Autowired
	Studentrepository studentrepository;
	@Override
	public Student save(Student student) {
		for(Telephone telephone:student.getTelephones()) {
			telephone.setStudent(student);
		}
		return studentrepository.save(student);
	}

	@Override
	public List<Student> fetch() {
		// TODO Auto-generated method stub
		return studentrepository.findAll();
	}

	@Override
	public Student fetch(Integer id) {
		// TODO Auto-generated method stub
		Optional<Student> student = studentrepository.findById(id);
		if(student.isPresent()) {
			return student.get();
		}
		else {
			return null;
		}
		
	}
	

}
