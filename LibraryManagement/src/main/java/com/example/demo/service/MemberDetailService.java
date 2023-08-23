package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.MemberDetailModel;
import com.example.demo.model.Response;

@Service
public interface MemberDetailService {
	
	public Response createmMember(MemberDetailModel values);
	
	public Response updateMember(String memberId, String emailId);
	
	public Response deleteMember(String memberId);
	
	public Response getAll();
	
	public Response getSpecific(String memberId);

}
