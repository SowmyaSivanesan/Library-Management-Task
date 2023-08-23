package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.BooksDetailModel;
import com.example.demo.model.Response;

@Service
public interface BookSDetailService {

	public Response createUser(BooksDetailModel values);

	public Response loginUser(String email, String password);

	public Response deleteBook(String bookId);

	public Response get(String bookId);

	public Response getAll();

}
