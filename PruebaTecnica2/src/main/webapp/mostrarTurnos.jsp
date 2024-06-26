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
    <body style="width: 100%; height: 100%; display: flex; justify-content: center; align-items: center; flex-direction: column">
        <div>
            <a style="color: white" href="turno.jsp"><button class="btn btn-secondary" style="position: fixed; right: 10%;">Volver</button></a>
            <h1>Listado de turnos</h1>
        </div>
        <div>            
            <form action="turnoFechaSv" method="GET">
                <div>
                    <h2>Filtrar turnos por fecha</h2>
                    <label>Fecha</label>
                    <input type="text" name="fechaBuscar"/>
                    <span>(año-mes-día)</span>                    
                </div>
                <button class="btn btn-primary" type="submit">Buscar</button>
            </form>
        </div>
        <div>
            <table>
                <tr>
                    <th>Turno</th>
                    <th>Ciudadano</th>
                    <th>Fecha</th>
                </tr>
                <%
                    List<Turno> turnos = (List) request.getSession().getAttribute("listaTurno");
                    for (Turno t : turnos) {
                %>
                <tr>
                    <td><%=t.getNumero()%></td>
                    <td><%=t.getCiudadano().getNombre()%></td>
                    <td><%=t.getFecha()%></td>
                </tr>
                <%}%>
            </table>
        </div>
    </body>
</html>
