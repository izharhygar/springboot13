package com.example.demo.controller;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.DummyPoint;

@Component
public interface DummyPointRepo extends JpaRepository<DummyPoint, String>{

	

}
