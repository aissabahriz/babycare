package com.javatpoint.dao;
import java.sql.*;
import java.util.*;

import com.javatpoint.bean.Baby;
import com.javatpoint.bean.BabySitter;
import com.javatpoint.bean.Moms;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class BabyDao {

	public static java.sql.Connection getCon(){
		java.sql.Connection con=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/babyBD?autoReconnect=true&&amp;useSSL=false","baby","baby");
		}catch(Exception e){System.out.println(e);}
		return con;
	
	}
	 public static boolean existUser(String email,String password)
	    {
	        String query = "select * from moms where email = ? and password = ?";
	        try
	        {
	        	java.sql.Connection con=getCon();
	            java.sql.PreparedStatement ps = con.prepareStatement(query);
	            ps.setString(1, email);
	           ps.setString(2, password);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next())
	            {
	                return true;
	            }
	            return false;
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	            return false;
	        }
	               
	        
	    }
	
	public static int save(Baby b){
		int status=0;
		try{
			java.sql.Connection con=getCon();
			java.sql.PreparedStatement ps=con.prepareStatement("insert into babyname(name,age,sex,weigth) values(?,?,?,?)");
			ps.setString(1,b.getName());
			ps.setInt(2,b.getAge());
			ps.setString(3,b.getSex());
			ps.setInt(4,b.getWeight());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int save(Moms m){
		int status=0;
		try{
			java.sql.Connection con=getCon();
			java.sql.PreparedStatement ps=con.prepareStatement("insert into moms(fullname,username,email,password,phone) values(?,?,?,?,?)");
			ps.setString(1,m.getFullname());
			ps.setString(2,m.getUsername());
			ps.setString(3,m.getEmail());
			ps.setString(4,m.getPassword());
			ps.setInt(5,m.getPhone());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int save(BabySitter s){
		int status=0;
		try{
			java.sql.Connection con=getCon();
			java.sql.PreparedStatement ps=con.prepareStatement("insert into babySitter(fullname,phone,salary,address) values(?,?,?,?)");
			ps.setString(1,s.getFullname());
			ps.setInt(2,s.getPhone());
			ps.setInt(3,s.getSalary());
			ps.setString(4,s.getAddress());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			java.sql.Connection con=getCon();
			java.sql.PreparedStatement ps=con.prepareStatement("delete from babyname where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
		
	}
	public static int deletemoms(int id){
		int status=0;
		try{
			java.sql.Connection con=getCon();
			java.sql.PreparedStatement ps=con.prepareStatement("delete from moms where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
		
	}
	public static int deletsitter(int id){
		int status=0;
		try{
			java.sql.Connection con=getCon();
			java.sql.PreparedStatement ps=con.prepareStatement("delete from babySitter where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
		
	}
	public static List<Baby> getAllRecords(){
		List<Baby> list=new ArrayList<Baby>();
		try{
			java.sql.Connection con=getCon();
			java.sql.PreparedStatement ps=con.prepareStatement("select * from babyname");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Baby b=new Baby();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setAge(rs.getInt(3));
				b.setSex(rs.getString(4));
				b.setWeight(rs.getInt(5));
				list.add(b);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	public static List<Baby> getRecordsByStart(String start){
		List<Baby> list=new ArrayList<Baby>();
		try{
			java.sql.Connection con=getCon();
			java.sql.PreparedStatement ps=con.prepareStatement("select * from babyname where name like '"+start+"%' ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Baby b=new Baby();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setAge(rs.getInt(3));
				b.setSex(rs.getString(4));
				b.setWeight(rs.getInt(5));
				list.add(b);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	public static List<Baby> getRecordsBySex(String sex){
		List<Baby> list=new ArrayList<Baby>();
		try{
			java.sql.Connection con=getCon();
			java.sql.PreparedStatement ps=con.prepareStatement("select * from babyname where sex=? ");
			ps.setString(1,sex);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Baby b=new Baby();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setAge(rs.getInt(3));
				b.setSex(rs.getString(4));
				b.setWeight(rs.getInt(5));
				list.add(b);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}

	public static List<Moms> getMomsAllRecords() {
		
		List<Moms> list=new ArrayList<Moms>();
		try{
			java.sql.Connection con=getCon();
			java.sql.PreparedStatement ps=con.prepareStatement("select * from moms");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Moms m=new Moms();
				m.setId(rs.getInt(1));
				m.setFullname(rs.getString(2));
				m.setUsername(rs.getString(3));
				m.setEmail(rs.getString(4));
				m.setPassword(rs.getString(5));
				m.setPhone(rs.getInt(6));
				list.add(m);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	public static String getUserName() {
		 String query = "select usernam from moms ";
	        try
	        {
	        	java.sql.Connection con=getCon();
	            java.sql.PreparedStatement ps = con.prepareStatement(query);
	            
	          
	            ResultSet rs = ps.executeQuery();
	            Moms U = new Moms();
				U.setUsername(rs.getString(1));
	            if(rs.next())
	            {
	                return getUserName();
	            }
	            return null;
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	            return null;
	        }
	}
}
