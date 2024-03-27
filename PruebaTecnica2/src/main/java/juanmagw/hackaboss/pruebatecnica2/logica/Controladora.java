package juanmagw.hackaboss.pruebatecnica2.logica;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import juanmagw.hackaboss.pruebatecnica2.persistencia.ControladoraPersistencia;

public class Controladora {
    
    ControladoraPersistencia controlCiud = new ControladoraPersistencia();
    ControladoraPersistencia controlTurn = new ControladoraPersistencia();
    
    public void crearCiudadano(Ciudadano ciudadano) {
        controlCiud.crearCiudadano(ciudadano);
    }
    
    public void crearTurno(Turno turno) {
        controlTurn.crearTurno(turno);
    }
    
    public List<Ciudadano> mostrarCiudadanos() {
        return controlCiud.mostrarCiudadanos();
    }
    
    public List<Turno> mostrarTurnos() {
        return controlTurn.mostrarTurnos();
    }
    
    public List<Turno> mostrarTurnosFecha(LocalDate fecha) {
        return mostrarTurnos().stream()
                .filter(t -> t.getFecha().equals(fecha))
                .collect(Collectors.toList());
    }
    
    public void editarCiudadano(Ciudadano ciudadano) {
        controlCiud.editarCiudadano(ciudadano);
    }
    
    public void editarTurno(Turno turno) {
        controlTurn.editarTurno(turno);
    }
    
    public void eliminarCiudadano(Long id) {
        controlCiud.eliminarCiudadano(id);
    }
    
    public void eliminarTurno(Integer numero) {
        controlTurn.eliminarTurno(numero);
    }
}
