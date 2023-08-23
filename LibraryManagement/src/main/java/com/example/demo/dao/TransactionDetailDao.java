package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

import com.example.demo.model.Response;
import com.example.demo.model.TransactionDetailModel;
import com.example.demo.service.TransactionDetailService;

@Component
public class TransactionDetailDao implements TransactionDetailService{
	
	Response rsp = new Response();
	
	String url = "jdbc:mysql://127.0.0.1:3306/library";
	String username = "root";
	String pswrd = "Sowmiya0209";

	@Override
	public Response issue(TransactionDetailModel value) {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			try(Connection conn = DriverManager.getConnection(url, username, pswrd);) {
//				if (String.valueOf(value.isOutstandhingFee()==true) {
//					
//				} else {
//
//				}
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();		}
//		
		return rsp;
	}

	@Override
	public Response returns(String memberId, String bookId) {
		
		return rsp;
	}

	@Override
	public Response allTransaction(String memberId, String bookId) {
	
		return rsp;
	}

}
