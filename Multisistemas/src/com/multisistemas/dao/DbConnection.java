package com.multisistemas.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbConnection {
	
	public static final String ZONA_HORARIA = "America/Guatemala";
	
	public java.sql.Connection con;
	public PreparedStatement stm;
	public ResultSet rst;
	public CallableStatement ctm;
	public String sql;
	protected int p;
	
	public void connect() throws SQLException {
		try {
			InitialContext ctx = new InitialContext();
			con = ((DataSource) ctx.lookup("java:/comp/env/jdbc/MultiConnection")).getConnection();			
			p = 1;
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		p = 0;
		if(this.rst!=null)try {this.rst.close();this.rst=null;}catch(Exception e) {}
		if(this.ctm!=null)try {this.ctm.close();this.ctm=null;}catch(Exception e) {}
		if(this.stm!=null)try {this.stm.close();this.stm=null;}catch(Exception e) {}
		if(this.con!=null)try {this.con.close();this.con=null;}catch(Exception e) {}
	}
	
	public static void closeConnection(java.sql.Connection con, PreparedStatement stm, ResultSet rst) {
		if(rst!=null)try {rst.close();rst=null;}catch(Exception e) {}
		if(stm!=null)try {stm.close();stm=null;}catch(Exception e) {}
		if(con!=null)try {con.close();con=null;}catch(Exception e) {}
	}

	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return (con!=null)?con.prepareStatement(sql):null;
	}

	public ResultSet executeQuery() throws SQLException {
		return (stm!=null)?stm.executeQuery():null;
	}
	
	public CallableStatement prepareCall(String sql) throws SQLException{
		return (con!=null)?con.prepareCall(sql):null;
	}
}
