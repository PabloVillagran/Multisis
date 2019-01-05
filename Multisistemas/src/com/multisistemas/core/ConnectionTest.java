package com.multisistemas.core;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multisistemas.dao.DbConnection;

/**
 * Servlet implementation class ConnectionTest
 */
@WebServlet("/ConnectionTest")
public class ConnectionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		DbConnection connection = new DbConnection();
		try {
			connection.connect();
			connection.stm = connection.prepareStatement("SELECT TO_CHAR(SYSDATE) d FROM DUAL");
			connection.rst = connection.executeQuery();
			if(connection.rst.next()) {
				response.getWriter().append(" TESTED CONECTION " + connection.rst.getString("D"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().append(" ").append(e.getMessage());
		} finally {
			connection.closeConnection();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
