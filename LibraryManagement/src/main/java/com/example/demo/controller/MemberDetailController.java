package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MemberDetailDao;
import com.example.demo.model.MemberDetailModel;
import com.example.demo.model.Response;

@CrossOrigin("*")
@RestController
@RequestMapping("mbr")
public class MemberDetailController {

	@Autowired
	MemberDetailDao dao;
	
	@PostMapping("/create")
	public ResponseEntity<Response> createMember(@RequestBody MemberDetailModel values){
		return ResponseEntity.ok(dao.createmMember(values));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Response> updateMember(@RequestParam String memberId, @RequestParam String emailId){
		return ResponseEntity.ok(dao.updateMember(memberId,emailId));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Response> deleteMember(@RequestParam String memberId){
		return ResponseEntity.ok(dao.deleteMember(memberId));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<Response> getAll(){
		return ResponseEntity.ok(dao.getAll());
	}
	
	@GetMapping("/get")
	public ResponseEntity<Response> getSpecific(@RequestParam String memberId){
		return ResponseEntity.ok(dao.getSpecific(memberId));
	}
	
}
