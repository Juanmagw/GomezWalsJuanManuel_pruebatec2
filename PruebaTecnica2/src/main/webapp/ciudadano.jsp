<%@page import="juanmagw.hackaboss.pruebatecnica2.logica.Ciudadano"%>
<%@page import="juanmagw.hackaboss.pruebatecnica2.logica.Turno"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="width: 100%; height: 100%">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body style="width: 100%; height: 100%; display: flex; justify-content: center; align-items: center; flex-direction: column">
        <div>
            <a style="color: white" href="index.jsp"><button class="btn btn-secondary" style="position: fixed; right: 10%;">Volver</button></a>
            <h1>Bienvenido al sistema gestor de ciudadanos</h1>
        </div>
        <div>
            <h3>Crear nuevo ciudadano</h3>
            <form action="ciudadanoSv" method="POST">
                <div>
                    <label>Nombre</label>
                    <input type="text" name="nombreCrear"/>
                </div>
                <button class="btn btn-primary" type="submit">Guardar</button>
            </form>
        </div>
        <div>
            <h3>Buscar ciudadanos</h3>
            <form action="ciudadanoSv" method="GET">                
                <button class="btn btn-primary" type="submit">Buscar</button>
            </form>
        </div>
        <div>
            <h3>Asignar turno a ciudadano</h3>          
            <form action="ciudadanoTurnoSv" method="GET">                
                <button class="btn btn-primary" type="submit">Buscar</button>
            </form>
        </div>
        <div>
            <h3>Eliminar ciudadano</h3>          
            <form action="ciudadanoEliminarSv" method="POST">
                <div>
                    <label>ID ciudadano</label>
                    <input type="number" name="idEliminar"/>
                </div>
                <button class="btn btn-primary" type="submit">Eliminar</button>
            </form>
        </div>
    </body>
</html>
