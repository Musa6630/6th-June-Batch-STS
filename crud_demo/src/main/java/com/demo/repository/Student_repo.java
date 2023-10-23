package com.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.entity.Student;

public interface Student_repo extends CrudRepository<Student, Integer> {

}
