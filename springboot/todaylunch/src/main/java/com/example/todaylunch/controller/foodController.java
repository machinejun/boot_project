package com.example.todaylunch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.todaylunch.dto.Food;
import com.example.todaylunch.dto.Store;
import com.example.todaylunch.service.Service;


@RestController
@RequestMapping("/lunch")
public class foodController {
	private Service service;
	
	public foodController() {
		this.service = Service.getinstance();
	}

	@GetMapping("/foods")
	public List<Food> food() {
		List<Food> foods = new ArrayList<Food>();
		foods = service.getFoodList();
		return foods;
	}
	
	@GetMapping("/food")
	public Food food(@RequestParam String foodName) {	
		Food food = service.findFood(foodName);
		return food;
	}
	
	@GetMapping("/stores/{limit}")
	public List<Store> stores(@PathVariable(name= "limit") int limit){
		System.out.println("호출됨");
		List<Store> stores = service.getNearStorelist();
		return stores;
		
	}
}
