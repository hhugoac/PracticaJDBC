package com.jdbcproject.controller;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.rmi.transport.Connection;

/**
 * Servlet implementation class buscarProductoServlet
 */
@WebServlet("/buscarProductoServlet")
public class buscarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buscarProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idProducto=request.getParameter("txtIdProducto");
		response.setContentType("text/html");
		//Define the connection variables to the DB
		String url="jdbc:mysql://localhost:3306/hugo"; //3306 port, /hugo databasename
		String nameUser="root";
		String password="root";
		
		//Put the database connections inside a try-catch statement
		try
		{
			//Create an Driver object from JDBC package com.mysql.jdbc
			//Driver objDriver=new Driver(); //Create an object DRiver but it is needed to import the module
			Class.forName("com.mysql.jdbc.Driver").newInstance(); //Create an object without name
			Connection conn=DriverManager.getConnection(url, nameUser, password);
			
			conn.close();
		}
		catch
		{
			
		}
		finally
		{
			
		}
	}

}
