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
            <h1>Bienvenido al sistema gestor te turnos</h1>
            <button><a href="index.jsp">Volver</a></button>           
        </div>
        <div>            
            <h3>Crear nuevo turno</h3>
            <form action="turnoSv" method="POST">
                <div>
                    <label>Número</label>
                    <input type="number" name="numeroCrear"/>
                </div>
                <div>
                    <label>Fecha</label>
                    <input type="text" name="fechaCrear"/>
                    <span>El formato de fecha es año-mes-día</span>
                </div>
                <div>
                    <label>Descripción</label>
                    <input type="text" name="descripcionCrear"/>
                </div>
                <button type="submit">Guardar</button>
            </form>
        </div>
        <div>
            <h3>Buscar turnos</h3>
            <form action="turnoSv" method="GET">
                <div>
                    <label>Fecha</label>
                    <input type="text" name="fechaBuscar"/>
                    <span>El formato de fecha es año-mes-día</span>
                </div>
                <button type="submit">Buscar</button>
            </form>
        </div>        
    </body>
</html>
