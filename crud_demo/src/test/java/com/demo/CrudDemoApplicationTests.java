package com.demo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entity.Student;
import com.demo.repository.Student_repo;

@SpringBootTest
class CrudDemoApplicationTests {
	@Autowired
	private Student_repo studentrepo;

	@Test
	void saveStudent() { 
		
		Student s=new Student();
		s.setName("Mansur Raja");
		s.setCourse("Full Stack developement");
		s.setFee(85000);
		
		studentrepo.save(s);
	}
	
	@Test
	public void  deletestudentinfo() {
		studentrepo.deleteById(5);
	}
	
	@Test
	public void findStudentbyId() {
		Optional<Student> findById = studentrepo.findById(1);
		if(findById.isPresent()) {
			Student student = findById.get();
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getCourse());
			System.out.println(student.getFee());
		}
		else {
			System.out.println("No Record Found");
		}
	}
	
	@Test
	public void updateById() {
		Optional<Student> obj = studentrepo.findById(1);
		Student student = obj.get();
		student.setFee(89000);
		studentrepo.save(student);
	}
	
	@Test
	public void findstudentExist() {
		boolean val = studentrepo.existsById(1);
		System.out.println(val);
	}

	@Test
	public void allStudent() { 
		Iterable<Student> findAll = studentrepo.findAll();
		System.out.println(findAll);
	}
}
