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
    <h3>Gestion de productos</h3>

    <ul>
        <li><a href="altaProducto.jsp">Alta de productos</a></li>
        <li><a href="altaProducto.jsp">Alta de productos con preprered Statement</a></li>
        <li><a href="borrarProducto.jsp">Borrar de productos</a></li>
        <li><a href="consultaIndividual.jsp">Consulta individual de un producto</a></li>
        <li><a href="ConsultaGeneralProductos.jsp">Consulta General de productos</a></li>
        <li><a href="modificarPrevio.jsp">Modificar Producto</a></li>
        <li><a href="transaccionProductos.jsp">Ejemplo de Transacciones Producto</a></li>
    </ul>
    <hr/>
    <h3>Gestión de clientes</h3>
    <ul>
        <li><a href="altaCliente.jsp">Agregar Cliente</a></li>
        <li><a href="borrarProducto.jsp">Borrar Cliente</a></li>
        <li><a href="consultaIndividual.jsp">Consulta individual de un cliente</a></li>
        <li><a href="ConsultaGeneralProductos.jsp">Consulta General de clientess</a></li>
        <li><a href="modificarProducto.jsp">Modificar registros de un cliente</a></li>
    </ul>

    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/script.js"></script>
</body>
</html>