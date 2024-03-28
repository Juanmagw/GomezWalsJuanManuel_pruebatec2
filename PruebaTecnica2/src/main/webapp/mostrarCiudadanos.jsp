<%@page import="juanmagw.hackaboss.pruebatecnica2.logica.Ciudadano"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="width: 100%; height: 100%;">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body style="width: 100%; height: 100%; display: flex; justify-content: center; align-items: center; flex-direction: column">
        <div>
            <a style="color: white" href="ciudadano.jsp"><button class="btn btn-primary" style="position: fixed; right: 10%;">Volver</button></a>
            <h1>Listado de ciudadanos</h1>
        </div>
        <div>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                </tr>
                <%
                    List<Ciudadano> ciudadanos = (List) request.getSession().getAttribute("listaCiudadano");
                    for (Ciudadano c : ciudadanos) {
                %>
                <tr>
                    <td><%=c.getId()%></td>
                    <td><%=c.getNombre()%></td>
                </tr>
                <%}%>
            </table>
        </div>       
    </body>
</html>
