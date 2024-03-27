<%@page import="juanmagw.hackaboss.pruebatecnica2.logica.Turno"%>
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
        <h1>Listado de turnos</h1>
        <table>
            <tr>
                <th>Turno</th>
                <th>Ciudadano</th>
                <th>Fecha</th>
            </tr>
            <%
                List<Turno> turnos = (List) request.getSession().getAttribute("listaTurnoFecha");
                for (Turno t : turnos) {
            %>
            <tr>
                <td><%=t.getNumero()%></td>
                <td><%=t.getCiudadano().getNombre()%></td>
                <td><%=t.getFecha()%></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
