package com.jdbcproject.controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class transactionServlet
 */
@WebServlet("/transactionServlet")
public class transactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public transactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//https://www.ibm.com/support/knowledgecenter/es/ssw_i5_54/rzaha/stateex.htm search info here
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
					
					//Step 5.1. Put the autocommit equals false to acummulate 
					conn.setAutoCommit(false);
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery("SELECT * FROM producto");
					
					// Execute the statements that you want to.
					try {
					isRecordSave=stmt.executeUpdate("INSERT INTO producto (idProducto,NombreProducto, Precio) VALUES (121,'Camisa',200.00)");
					isRecordSave=stmt.executeUpdate("INSERT INTO producto (idProducto,NombreProducto, Precio) VALUES (122,'Varita magica',300.00)");
					isRecordSave=stmt.executeUpdate("INSERT INTO producto (idProducto,NombreProducto, Precio) VALUES (123,'Cazuela',400.00)");
					conn.commit();
					}
					
					catch(SQLException ex)
					{
						conn.rollback();
						response.getWriter().println("La transaccion fallo");
						response.getWriter().write("<li><a href='index.jsp'>Inicio</a></li>");
					}
					try
					{
						stmt.close();
						conn.close();
					}catch(SQLException e)
					{
						e.printStackTrace();
					}
					
					
				}
				catch(Exception e)
				{
					response.getWriter().println("Error al cerrar la base de datos");
					e.printStackTrace();
				}
				
	}

}
