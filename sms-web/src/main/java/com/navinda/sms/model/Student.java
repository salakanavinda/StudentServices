package com.navinda.sms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Student {
	@Id
	private Integer id;
	private String name;
	private String city;
	
	@OneToOne (cascade = CascadeType.ALL)
	private Address address;
	@OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
	private List<Telephone> telephones;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="student_courses",
			joinColumns = @JoinColumn(name="sid",referencedColumnName = "id"),
			inverseJoinColumns =  @JoinColumn(name="cid",referencedColumnName = "id")
			)
	private List<Course> courses;
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public List<Telephone> getTelephones() {
		return telephones;
	}
	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	

}
