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
 * Servlet implementation class altaProductoStatementServlet
 */
@WebServlet("/altaProductoStatementServlet")
public class altaProductoStatementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public altaProductoStatementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idProducto=request.getParameter("txtIdProducto");
		String NombreProducto=request.getParameter("txtProdName");
		String Precio=request.getParameter("txtPrecio");
		
		response.setContentType("text/html");
		//Step 1. Define the connection variables to the DB
		String url="jdbc:mysql://localhost:3306/hugo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //3306 port, /hugo databasename
		//The statemnet after ? in the previous line means: useUnicode=true  useJDBCCompliantTimezoneShift=True  useLegacyDatetimeCode=false serverTime=UTC
		String nameUser="root";
		String password="root";
		int isRecordSave=0;
		//Put the database connections inside a try-catch statement
		try
		{
			//Create an Driver object from JDBC package com.mysql.jdbc
			//Driver objDriver=new Driver(); //Create an object DRiver but it is needed to import the module
			Class.forName("com.mysql.jdbc.Driver").newInstance(); //Create an object without name
			java.sql.Connection conn = DriverManager.getConnection(url, nameUser, password); //Instancing  driver 
			
			
			Statement stmt=conn.prepareStatement("INSERT INTO producto values(?,?,?)");
			
			
			// Adds a new register to the DB
			stmt.setInt(1,idProducto);
			stmt.setString(2,idProducto);
			stmt.setDouble(3,idProducto);
			
			if(isRecordSave==1)
			{
				response.getWriter().write("Registro guardado");
			}
			else
			{
				response.getWriter().write("Registro no guardado");
			}	
			response.getWriter().println("El producto se agrego exitosamente");
			response.getWriter().write("<li><a href='index.jsp'>Inicio</a></li>");
			
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			response.getWriter().write("Exception" + e);
		}
	
	}

}
