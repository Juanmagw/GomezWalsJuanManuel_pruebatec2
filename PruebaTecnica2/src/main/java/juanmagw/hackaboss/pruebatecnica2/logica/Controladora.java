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

    public Ciudadano mostrarCiudadanoId(Long id) {
        return mostrarCiudadanos().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .get();
    }

    public List<Turno> mostrarTurnos() {
        return controlTurn.mostrarTurnos();
    }

    public Turno mostrarTurnoNumero(Integer numero) {
        return mostrarTurnos().stream()
                .filter(c -> c.getNumero().equals(numero))
                .findFirst()
                .get();
    }

    public List<Turno> mostrarTurnosFecha(LocalDate fecha) {
        return mostrarTurnos().stream()
                .filter(t -> t.getFecha().equals(fecha))
                .collect(Collectors.toList());
    }

    public List<Turno> mostrarTurnosEstado(LocalDate fecha, String estado) {
        return mostrarTurnosFecha(fecha).stream()
                .filter(t -> t.getEstado().equals(estado))
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
