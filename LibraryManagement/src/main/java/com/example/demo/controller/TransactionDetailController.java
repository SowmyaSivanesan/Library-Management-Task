package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.TransactionDetailDao;
import com.example.demo.model.Response;
import com.example.demo.model.TransactionDetailModel;

@CrossOrigin("*")
@RestController
@RequestMapping("/tran")
public class TransactionDetailController {

	@Autowired
	TransactionDetailDao dao;
	
	@PostMapping("/issue")
	public ResponseEntity<Response> issue(@RequestBody TransactionDetailModel value) {
		return ResponseEntity.ok(dao.issue(value));
	}
	
	@PostMapping("/return")
	public ResponseEntity<Response> returns(@RequestParam String memberId,@RequestParam String bookId) {
		return ResponseEntity.ok(dao.returns(memberId, bookId));
	}
	
	@GetMapping("/allTransaction")
	public ResponseEntity<Response> allTransaction(@RequestParam String memberId,@RequestParam String bookId) {
		return ResponseEntity.ok(dao.allTransaction(memberId, bookId));
	}
	
	
}
