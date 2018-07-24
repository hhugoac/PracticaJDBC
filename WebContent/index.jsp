<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Práctica de JDBC</title>
</head>
<body>
    <h1>Práctica con JDBC</h1>
    
    <form action="buscarProductoServlet" method="POST">
        <p>
            <label for="txtIdProducto" >Introduce el Id del producto</label>
            <input type="text" id="txtIdProducto" name="txtIdProducto">
        </p>
        <p>
            <input type="submit" value="Consultar producto">
        </p>
    </form>
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/script.js"></script>
</body>
</html>