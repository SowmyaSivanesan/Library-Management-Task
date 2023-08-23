package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BooksDetailDao;
import com.example.demo.model.BooksDetailModel;
import com.example.demo.model.Response;



@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class BooksDetailController {

	@Autowired
	BooksDetailDao dao;

	@PostMapping("/create")
	public ResponseEntity<Response> createBook(@RequestBody BooksDetailModel values) {
		return ResponseEntity.ok(dao.createUser(values));
	}
	
	@PostMapping("/login")
	public ResponseEntity<Response> updateBook(@RequestParam String email, @RequestParam String password){
		return ResponseEntity.ok(dao.loginUser(email,password));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Response> deleteBook(@RequestParam String bookId){
		return ResponseEntity.ok(dao.deleteBook(bookId));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<Response> getAll(){
		return ResponseEntity.ok(dao.getAll());
	}
	
	@GetMapping("get")
	public ResponseEntity<Response> get(@RequestParam String bookId){
		return ResponseEntity.ok(dao.get(bookId));
	}
}
	