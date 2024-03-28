<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html  style="width: 100%; height: 100%;">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body style="width: 100%; height: 100%; display: flex; justify-content: center; align-items: center; flex-direction: column;">
        <div>
            <a style="color: white" href="index.jsp"><button class="btn btn-secondary" style="position: fixed; right: 10%;">Volver</button></a>
            <h1>Bienvenido al sistema gestor de turnos</h1>
        </div>
        <div style="text-align: left">            
            <h3 style="text-align: center">Crear nuevo turno</h3>
            <form action="turnoSv" method="POST">
                <div>
                    <label>Número</label>
                    <input type="number" name="numeroCrear"/>
                </div>
                <div>
                    <label>Fecha</label>
                    <input type="text" name="fechaCrear"/>
                    <span>(año-mes-día)</span>
                </div>
                <div>
                    <label>Descripción</label>
                    <input type="text" name="descripcionCrear"/>
                </div>
                <button class="btn btn-primary" type="submit">Guardar</button>
            </form>
        </div>
        <div>
            <h3 style="text-align: center">Cambiar estado de un turno</h3>
            <form action="turnoCambioEstadoSv" method="POST">
                <label>Número</label>
                <input type="number" name="numeroCambiarEstado"/>
                <button class="btn btn-primary" type="submit">Cambiar</button>
            </form>
        </div>
        <div>
            <h3 style="text-align: center">Buscar turnos</h3>
            <form action="turnoSv" method="GET">
                <button class="btn btn-primary" type="submit">Buscar</button>
            </form>
        </div>  
        <div>
            <h3 style="text-align: center">Eliminar turno</h3>          
            <form action="turnoEliminarSv" method="POST">
                <div>
                    <label>Número</label>
                    <input type="number" name="numeroEliminar"/>
                </div>
                <button class="btn btn-primary" type="submit">Eliminar</button>
            </form>
        </div>
    </body>
</html>
