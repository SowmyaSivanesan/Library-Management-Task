package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import com.example.demo.model.MemberDetailModel;
import com.example.demo.model.Response;
import com.example.demo.service.MemberDetailService;


@Component
public class MemberDetailDao implements MemberDetailService{

	Response rsp = new Response();

	String url = "jdbc:mysql://127.0.0.1:3306/library";
	String username = "root";
	String pswrd = "Sowmiya0209";

	@Override
	public Response createmMember(MemberDetailModel values) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection conn = DriverManager.getConnection(url, username, pswrd);
					Statement st = conn.createStatement();) {

				String insertQuery = "INSERT INTO member_details(member_id, member_name, member_email, address, phone_number, outstanding_fee,status)VALUES('"
						+ values.getMemberId() + "','" + values.getName() + "','" + values.getEmail() + "','"
						+ values.getAddress() + "','" + values.getPhoneNumber() + "','" + values.isOutstandhingFee()
						+ "','" + values.isStatus() + "');";

				st.executeUpdate(insertQuery);

				rsp.setData("User Created Successfully!");
				rsp.setRespondCode(200);
				rsp.setRespondMsg("success");

			} catch (Exception e) {
				e.printStackTrace();

				rsp.setData("Coundn't Create User!");
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
	public Response updateMember(String memberId, String emailId) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection conn = DriverManager.getConnection(url, username, pswrd);
					Statement st = conn.createStatement();) {

				String updateQuery = "Update member_details set member_id ='" + memberId + "' where member_email='"
						+ emailId + "'";

				st.executeUpdate(updateQuery);

				rsp.setData("Member Updated Successfully!");
				rsp.setRespondCode(200);
				rsp.setRespondMsg("success");

			} catch (Exception e) {
				e.printStackTrace();

				rsp.setData("Cannot Update Member!");
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
	public Response deleteMember(String memberId) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection conn = DriverManager.getConnection(url, username, pswrd);
					Statement st = conn.createStatement();) {

				String deleteQuery = "delete from  member_details where member_id ='" + memberId + "'";

				st.executeUpdate(deleteQuery);

				rsp.setData("Member Deleted Successfully!");
				rsp.setRespondCode(200);
				rsp.setRespondMsg("success");

			} catch (Exception e) {
				e.printStackTrace();

				rsp.setData("Cannot delete Member!");
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

	@SuppressWarnings("unchecked")
	@Override
	public Response getAll() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String selectQuery = "select * from member_details;";

			try (Connection conn = DriverManager.getConnection(url, username, pswrd);
					Statement st = conn.createStatement();
					ResultSet rst = st.executeQuery(selectQuery);) {

				JSONArray jsonArray = new JSONArray();

				while (rst.next()) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("memberId", rst.getString("member_id"));
					jsonObject.put("memberName", rst.getString("member_name"));
					jsonObject.put("email", rst.getString("member_email"));
					jsonObject.put("address", rst.getString("address"));
					jsonObject.put("phoneNumber",rst.getLong("phone_number"));
					jsonObject.put("outstandhingFee", rst.getBoolean("outstanding_fee"));
					jsonObject.put("status", rst.getBoolean("status"));

					jsonArray.add(jsonObject);

				}

				rsp.setData("Member Fetch Successfully!");
				rsp.setRespondCode(200);
				rsp.setRespondMsg("success");
				rsp.setjData(jsonArray);

			} catch (Exception e) {
				e.printStackTrace();

				rsp.setData("Cannot Fetch Member!");
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
	public Response getSpecific(String memberId) {
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String selectQuery = "select * from member_details where member_id ='" + memberId + "'";

			JSONObject jasoJsonObject = new JSONObject();
			try (Connection conn = DriverManager.getConnection(url, username, pswrd);
					Statement stm = conn.createStatement();
					ResultSet rst = stm.executeQuery(selectQuery)) {

				while (rst.next()) {

					jasoJsonObject.put("memberId", rst.getString("member_id"));
					jasoJsonObject.put("memberName", rst.getString("member_name"));
					jasoJsonObject.put("email", rst.getString("member_email"));
					jasoJsonObject.put("address", rst.getString("address"));
					jasoJsonObject.put("phoneNumber", rst.getLong("phone_number"));
					jasoJsonObject.put("outstandingFee", rst.getBoolean("outstanding_fee"));
					jasoJsonObject.put("status", rst.getBoolean("status"));
					
					
				}
				rsp.setData("Member fetched Successfully!");
				rsp.setRespondCode(200);
				rsp.setRespondMsg("success");
				rsp.setjData(jasoJsonObject);

			} catch (Exception e) {
				e.printStackTrace();

				rsp.setData("Cannot Fetch Member!");
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
