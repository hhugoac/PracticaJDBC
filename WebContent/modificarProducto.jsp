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
 
    <form action="modificarProductoServlet" method="POST">

        <p>
            <label for="txtIdProducto" >Introduce el Id del producto</label>
            <input type="text" id="txtIdProducto" name="txtIdProducto" value="<%=request.getAttribute("AttrIdProduct")%>" disable>
        </p>
        <p>
            <label for="txtProdName" >Introduce el Nombre </label>
            <input type="text" id="txtProdNamee" name="txtProdName" value="<%=request.getAttribute("AttrnameProduct")%>">
        </p>
        <p>
            <label for="txtPrecio" >Introduce el Precio</label>
            <input type="text" id="txtPrecio" name="txtPrecio" value="<%=request.getAttribute("AttrpriceProduct")%>">
        </p>

        <p>
            <input type="submit" value="Modificar">
        </p>
    </form>
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/script.js"></script>
</body>
</html>