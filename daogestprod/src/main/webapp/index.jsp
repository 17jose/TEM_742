<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Producto"%>
<%
    List<Producto> producto = (List<Producto>) request.getAttribute("producto");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>

        <div class="container">
            <h2>SEGUNDO PARCIAL TEM-742</h2>
            <p>Nombre :</p>
            <p>Jose Luis Llamaca Huarachi</p>
            <p>Carnet : </p>
            <p>8313303 LP.</p>         
        </div>
        
        <h1>Gestion de Productos</h1>
        <a href="Inicio?action=add">Nuevo</a>
        <table>
            <tr>
                <th>Id</th>
                <th>Descripcion</th>
                <th>Cantidad</th>
                <th>Precio</th>
                <th>Categoria</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${producto}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.descripcion}</td>
                    <td>${item.cantidad}</td>
                    <td>${item.precio}</td>
                    <td>${item.categoria}</td>
                    <td> <a href="Inicio?action=edit&id=${item.id}">Editar</a></td>
                    <td> <a href="Inicio?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro de eliminar ???'))">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
