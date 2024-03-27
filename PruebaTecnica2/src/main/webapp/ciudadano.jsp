<%@page import="juanmagw.hackaboss.pruebatecnica2.logica.Ciudadano"%>
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
        <div>
            <h1>Bienvenido al sistema gestor te ciudadanos</h1>
            <button><a href="index.jsp">Volver</a></button>           
        </div>
        <div>
            <h3>Crear nuevo ciudadano</h3>
            <form action="ciudadanoSv" method="POST">
                <div>
                    <label>Nombre</label>
                    <input type="text" name="nombreCrear"/>
                </div>
                <button type="submit">Guardar</button>
            </form>
        </div>
        <div>
            <h3>Buscar ciudadanos</h3>
            <form action="ciudadanoSv" method="GET">                
                <button type="submit">Buscar</button>
            </form>
        </div>
        <div>
            <h3>Asignar turno a ciudadano</h3>
            <form action="ciudadanoTurnoSv" method="GET">
                <div>
                    <h3>Turnos</h3>
                    <table>
                        <tr>
                            <th>Número</th>
                        </tr>
                        <%
                            List<Turno> turnos = (List) request.getSession().getAttribute("listaTurnos");
                            for (Turno t : turnos) {
                        %>
                        <tr>
                            <td><%=t.getNumero()%></td>
                        </tr>
                        <%}%>
                    </table>               
                </div>
            </form>
            <form action="ciudadanoTurnoSv" method="GET">
                <div>
                    <h3>Turnos</h3>
                    <table>
                        <tr>
                            <th>Número</th>
                        </tr>
                        <%
                            List<Ciudadano> ciudadanos = (List) request.getSession().getAttribute("listaCiudadanos");
                            for (Ciudadano c : ciudadanos) {
                        %>
                        <tr>
                            <td><%=c.getNombre()%></td>
                        </tr>
                        <%}%>
                    </table>               
                </div>
            </form>
            <form action="ciudadanoTurnoSv" method="POST">
                <div>
                    <label>Ciudadano</label>
                    <input type="text" name="ciudadanoTurno"/>
                </div>
                <div>
                    <label>Turno</label>
                    <input type="number" name="turnoCiudadano"/>
                </div>
                <button type="submit">Guardar</button>
            </form>
        </div>
    </body>
</html>
