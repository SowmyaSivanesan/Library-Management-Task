package com.example.demo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import com.example.demo.model.BooksDetailModel;
import com.example.demo.model.Response;
import com.example.demo.service.BookSDetailService;

@Component
public class BooksDetailDao implements BookSDetailService {

	Response rsp = new Response();

	String url = "jdbc:mysql://127.0.0.1:3306/library";
	String username = "root";
	String pswrd = "Sowmiya0209";

	@Override
	public Response createUser(BooksDetailModel values) {

		Date date = new Date(Calendar.getInstance().getTime().getTime());

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection conn = DriverManager.getConnection(url, username, pswrd);
					Statement st = conn.createStatement();) {

				String insertQuery = "INSERT INTO book_details(book_id, title, author, available_Stock, location)VALUES('"
						+ values.getBookId() + "','" + values.getBookTitle() + "','" + values.getAuthorName() + "','"
						+ values.getAvailableStock() + "','" + values.getLocation() + "');";

				st.executeUpdate(insertQuery);

				rsp.setData("User Created Successfully!");
				rsp.setRespondCode(200);
				rsp.setRespondMsg("success");

			} catch (Exception e) {
				e.printStackTrace();

				rsp.setData("Coundn't Add Book");
				rsp.setRespondCode(500);
				rsp.setRespondMsg("failed");
			}

		} catch (Exception e) {
			e.printStackTrace();

			rsp.setData("Driver Class Error!");
			rsp.setRespondCode(500);
			rsp.setRespondMsg("error");
		}

		return rsp;
	}

	@Override
	public Response loginUser(String email, String password) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String selectQuery = "select * from member_details where email ='" + email + "' and password ='" + password
					+ "'";

			try (Connection conn = DriverManager.getConnection(url, username, pswrd);
					PreparedStatement preparest = conn.prepareStatement(selectQuery);
					ResultSet rs = preparest.executeQuery();) {

				String result;

				if (rs.next()) {
					result = "Existing User";
				} else {
					result = "No such user found";
				}

				rsp.setData(result);
				rsp.setRespondCode(200);
				rsp.setRespondMsg("success");

			} catch (Exception e) {
				e.printStackTrace();

				rsp.setData("User failed to login");
				rsp.setRespondCode(500);
				rsp.setRespondMsg("error");

			}

		} catch (Exception e) {
			e.printStackTrace();

			rsp.setData("Driver Class Error!");
			rsp.setRespondCode(500);
			rsp.setRespondMsg("error");
		}

		return rsp;
	}

	@Override
	public Response deleteBook(String bookId) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection conn = DriverManager.getConnection(url, username, pswrd);
					Statement st = conn.createStatement();) {

				String deleteQuery = "delete from book_details where book_id ='" + bookId + "'";

				st.executeUpdate(deleteQuery);

				rsp.setData("Deleted Successfully!");
				rsp.setRespondCode(200);
				rsp.setRespondMsg("success");

			} catch (Exception e) {
				e.printStackTrace();

				rsp.setData("Cannot delete Book!");
				rsp.setRespondCode(500);
				rsp.setRespondMsg("error");
			}

		} catch (Exception e) {
			e.printStackTrace();

			rsp.setData("Driver Class Error!");
			rsp.setRespondCode(500);
			rsp.setRespondMsg("error");
		}

		return rsp;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Response getAll() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String selectQuery = "select * from book_details;";

			try (Connection conn = DriverManager.getConnection(url, username, pswrd);
					Statement st = conn.createStatement();
					ResultSet rst = st.executeQuery(selectQuery);) {

				JSONArray jsonArray = new JSONArray();

				while (rst.next()) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("bookId", rst.getString("book_id"));
					jsonObject.put("bookTitle", rst.getString("book_title"));
					jsonObject.put("authorName", rst.getString("author"));
					jsonObject.put("location", rst.getString("location"));
					jsonObject.put("availableStock", rst.getString("stock_available"));

					jsonArray.add(jsonObject);

				}

				rsp.setData("User Fetch Successfully!");
				rsp.setRespondCode(200);
				rsp.setRespondMsg("success");
				rsp.setjData(jsonArray);

			} catch (Exception e) {
				e.printStackTrace();

				rsp.setData("Cannot Fetch User!");
				rsp.setRespondCode(500);
				rsp.setRespondMsg("error");

			}

		} catch (Exception e) {
			e.printStackTrace();

			rsp.setData("Driver Class Error!");
			rsp.setRespondCode(500);
			rsp.setRespondMsg("error");

		}

		return rsp;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Response get(String bookId) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String selectQuery = "select * from book_details where book_id ='" + bookId + "'";

			JSONObject jasoJsonObject = new JSONObject();
			try (Connection conn = DriverManager.getConnection(url, username, pswrd);
					Statement stm = conn.createStatement();
					ResultSet rst = stm.executeQuery(selectQuery)) {

				while (rst.next()) {

					jasoJsonObject.put("bookId", rst.getString("book_id"));
					jasoJsonObject.put("bookTitle", rst.getString("book_title"));
					jasoJsonObject.put("authorName", rst.getString("author"));
					jasoJsonObject.put("location", rst.getString("location"));
					jasoJsonObject.put("availableStock", rst.getString("stock_available"));

				}
				rsp.setData("Fetched book Deatils successfully!");
				rsp.setRespondCode(200);
				rsp.setRespondMsg("success");
				rsp.setjData(jasoJsonObject);

			} catch (Exception e) {
				e.printStackTrace();

				rsp.setData("Cannot Book Detail!");
				rsp.setRespondCode(500);
				rsp.setRespondMsg("error");
			}

		} catch (Exception e) {
			e.printStackTrace();

			rsp.setData("Driver Class Error!");
			rsp.setRespondCode(500);
			rsp.setRespondMsg("error");
		}

		return rsp;
	}

}
