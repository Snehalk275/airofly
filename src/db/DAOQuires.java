package db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class DAOQuires {
	public String checkLogin(String email, String password) {
		// TODO Auto-generated method stub
		DAO data=new DAO();
		Connection conn=data.getConnection();
		String validateUser = "select * from  registration where emailid=? and password = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(validateUser);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet result=preparedStatement.executeQuery();
			if(result.next())
			{
				return result.getString(1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String getList() {
		// TODO Auto-generated method stub
		DAO data=new DAO();
		Connection conn=data.getConnection();
		String validateUser = "select * from  complaint";
		PreparedStatement preparedStatement;
		String a ="";
		try {
			preparedStatement = conn.prepareStatement(validateUser);
			
			ResultSet result=preparedStatement.executeQuery();
			while(result.next())
			{
				a = a + result.getString(1) + " " +result.getString(2) + " " + result.getString(3) + " " + result.getString(4) +"\n";
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	public boolean insertReg(String strName, String email, String password) {
		int rows = 0;
	DAO dao=new DAO();
	
	Connection conn=dao.getConnection();
	String insertquery="insert into registration values(?,?,?)";
	PreparedStatement pstmt=null;
	try{
		pstmt=conn.prepareStatement(insertquery);;
		pstmt.setString(1,email);
		pstmt.setString(2,strName);
		pstmt.setString(3,password);
		rows=pstmt.executeUpdate();
	
	}catch(SQLException e){
		System.out.println(e);
	}
	finally{
		try {
			pstmt.close();
		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	if(rows==0)
		return false;
	
	return true;

	}
	public boolean insertComplaint(String complaintType, String address, String description) {
		int rows = 0;
	DAO dao=new DAO();
	
	Connection conn=dao.getConnection();
	String insertquery="insert into complaint values(?,?,?,?,?)";
	PreparedStatement pstmt=null;
	try{
		pstmt=conn.prepareStatement(insertquery);;
		pstmt.setString(1,address);
		pstmt.setString(2,description);
		pstmt.setString(3,complaintType);
		pstmt.setString(4,"Open");
		pstmt.setString(5,address+ " " + description + " " +complaintType );
		rows=pstmt.executeUpdate();
	
	}catch(SQLException e){
		System.out.println(e);
	}
	finally{
		try {
			pstmt.close();
		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	if(rows==0)
		return false;
	
	return true;

	}
	public void update(String item) {
		// TODO Auto-generated method stub
		DAO data=new DAO();
		Connection conn=data.getConnection();
		String validateUser = "select status from  complaint where msg=?";
		PreparedStatement preparedStatement;
		String a = "";
		try {
			preparedStatement = conn.prepareStatement(validateUser);
			preparedStatement.setString(1, item.substring(0,item.lastIndexOf(" ")));
			System.out.println("-"+preparedStatement.toString() + "@@");
			ResultSet result=preparedStatement.executeQuery();
			if(result.next())
			{
				a = result.getString(1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if("Open".equals(a))
			a = "InProgress";
		else if("InProgress".equals(a))
			a = "Close";
		else
			a = "Reject";
		
		DAO dao=new DAO();
		
		String insertquery="update  complaint set status =? where msg =?";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(insertquery);;
			pstmt.setString(2,item.substring(0,item.lastIndexOf(" ")));
			pstmt.setString(1,a);
			System.out.println("-"+pstmt.toString() + "@@");
			pstmt.executeUpdate();
		
		}catch(SQLException e){
			System.out.println(e);
		}
		finally{
			try {
				pstmt.close();
			conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	

		}
		
		
	}
	
}
