package com.jdbcproject.controller;

import java.io.IOException;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class borraProducto
 */
@WebServlet("/borraProducto")
public class borraProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public borraProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Steps to create a DB Connection in a Java Servlet
		 * 
		 * */
		String idProducto=request.getParameter("txtIdProducto");
		response.setContentType("text/html");
		//Step 1. Define the connection variables to the DB
		String url="jdbc:mysql://localhost:3306/hugo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //3306 port, /hugo databasename
		//The statemnet after ? in the previous line means: useUnicode=true  useJDBCCompliantTimezoneShift=True  useLegacyDatetimeCode=false serverTime=UTC
		String nameUser="root";
		String password="root";
		
		//Put the database connections inside a try-catch statement
		try
		{
			//Create an Driver object from JDBC package com.mysql.jdbc
			//Driver objDriver=new Driver(); //Create an object DRiver but it is needed to import the module
			Class.forName("com.mysql.jdbc.Driver").newInstance(); //Create an object without name
			java.sql.Connection conn = DriverManager.getConnection(url, nameUser, password); //Se instancia el driver 
			
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM producto");
			
			// Adds a new register to the DB
			stmt.executeUpdate("DELETE FROM producto WHERE idProducto='"+idProducto +"'");
			
			
			response.getWriter().println("El producto se elimino exitosamente");
			response.getWriter().write("<li><a href='index.jsp'>Inicio</a></li>");
			
			response.getWriter().println("El producto se modifico exitosamente");
			response.getWriter().write("<li><a href='index.jsp'>Inicio</a></li>");
			
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//rs.close();
			//stmt.close();
		}
	}

}
