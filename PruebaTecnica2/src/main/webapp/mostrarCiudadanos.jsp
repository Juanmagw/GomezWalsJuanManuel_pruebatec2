<%@page import="juanmagw.hackaboss.pruebatecnica2.logica.Ciudadano"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de ciudadanos</h1>
        <table>
            <tr>
                <th>Nombre</th>
            </tr>
            <%
                List<Ciudadano> ciudadanos = (List) request.getSession().getAttribute("listaCiudadano");
                for (Ciudadano c : ciudadanos) {
            %>
            <tr>
                <td><%=c.getNombre()%></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
