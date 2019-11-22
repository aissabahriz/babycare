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
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?autoReconnect=true&&amp;useSSL=false","baby","baby");
		}catch(Exception e){System.out.println(e);}
		return con;
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
			java.sql.PreparedStatement ps=con.prepareStatement("insert into moms(fullname,phone,payment) values(?,?,?)");
			ps.setString(1,m.getFullname());
			ps.setInt(2,m.getPhone());
			ps.setInt(3,m.getPayment());
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
			java.sql.PreparedStatement ps=con.prepareStatement("select * from babyname where religion=? ");
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
}
