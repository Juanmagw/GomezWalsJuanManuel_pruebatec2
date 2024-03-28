<%@page import="juanmagw.hackaboss.pruebatecnica2.logica.Ciudadano"%>
<%@page import="juanmagw.hackaboss.pruebatecnica2.logica.Turno"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="width: 100%; height: 100%;">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body style="width: 100%; height: 100%; display: flex; justify-content: center; align-items: center">
        <div>
            <div style="display: flex">
                <div style="margin-right: 10px;">
                    <a style="color: white" href="ciudadano.jsp"><button class="btn btn-secondary" style="position: fixed; right: 10%;">Volver</button></a>
                    <h2 style="text-align: center">Turnos</h2>
                    <table>
                        <tr>
                            <th>Número</th>
                            <th>Fecha</th>
                            <th>Estado</th>
                        </tr>
                        <%
                            List<Turno> turnos = (List) request.getSession().getAttribute("turnos");
                            for (Turno t : turnos) {
                        %>
                        <tr>
                            <td><%=t.getNumero()%></td>
                            <td><%=t.getFecha()%></td>
                            <td><%=t.getEstado()%></td>
                        </tr>
                        <%}%>
                    </table>               
                </div>
                <div>
                    <h2 style="text-align: center">Ciudadanos</h2>
                    <table>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                        </tr>
                        <%
                            List<Ciudadano> ciudadanos = (List) request.getSession().getAttribute("ciudadanos");
                            for (Ciudadano c : ciudadanos) {
                        %>
                        <tr>
                            <td><%=c.getId()%></td>
                            <td><%=c.getNombre()%></td>
                        </tr>
                        <%}%>
                    </table>               
                </div>
            </div>
            <form action="ciudadanoTurnoSv" method="POST">
                <div>
                    <label>ID Ciudadano</label>
                    <input type="number" name="ciudadanoTurno"/>
                </div>
                <div>
                    <label>Número Turno</label>
                    <input type="number" name="turnoCiudadano"/>
                </div>
                <button class="btn btn-primary" type="submit">Guardar</button>
            </form>
        </div>
    </body>
</html>
