package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Response;
import com.example.demo.model.TransactionDetailModel;

@Service
public interface TransactionDetailService {
	
	public Response issue(TransactionDetailModel value);
	
	public Response returns(String memberId, String bookId);

	public Response allTransaction(String memberId, String bookId);
}
