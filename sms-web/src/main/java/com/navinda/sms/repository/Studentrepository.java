package com.navinda.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navinda.sms.model.Student;

public interface Studentrepository extends JpaRepository<Student, Integer> {

}
