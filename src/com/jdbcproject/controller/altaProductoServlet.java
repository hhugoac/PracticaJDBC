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
 * Servlet implementation class altaProductoServlet
 */
@WebServlet("/altaProductoServlet")
public class altaProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public altaProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//https://www.ibm.com/support/knowledgecenter/es/ssw_i5_54/rzaha/stateex.htm search info here
		String idProducto=request.getParameter("txtIdProducto");
		String NombreProducto=request.getParameter("txtProdName");
		String Precio=request.getParameter("txtPrecio");
		
		response.setContentType("text/html");
		//Define the connection variables to the DB
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
			stmt.executeUpdate("INSERT INTO producto (idProducto,NombreProducto, Precio) VALUES ('"+idProducto +"','"+NombreProducto +"','"+Precio+"')");
			
			//Make an single consult on the DB
			
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			response.getWriter().write("Exception" + e);
		}
		finally
		{
			response.getWriter().write("No jalo");
		}
	}

}
