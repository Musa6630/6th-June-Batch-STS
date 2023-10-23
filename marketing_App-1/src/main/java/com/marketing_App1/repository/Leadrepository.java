package com.marketing_App1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketing_App1.entity.Lead;

public interface Leadrepository extends JpaRepository<Lead, Long> {

}
