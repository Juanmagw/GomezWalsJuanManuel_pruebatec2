package juanmagw.hackaboss.pruebatecnica2.persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import juanmagw.hackaboss.pruebatecnica2.logica.Ciudadano;
import juanmagw.hackaboss.pruebatecnica2.logica.Turno;
import juanmagw.hackaboss.pruebatecnica2.persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {

    CiudadanoJpaController controlPersisCiud = new CiudadanoJpaController();
    TurnoJpaController controlPersisTurn = new TurnoJpaController();

    public void crearCiudadano(Ciudadano ciudadano) {
        controlPersisCiud.create(ciudadano);
    }

    public void crearTurno(Turno turno) {
        controlPersisTurn.create(turno);
    }

    public List<Ciudadano> mostrarCiudadanos() {
        return controlPersisCiud.findCiudadanoEntities();
    }

    public List<Turno> mostrarTurnos() {
        return controlPersisTurn.findTurnoEntities();
    }

    public void editarCiudadano(Ciudadano ciudadano) {
        try {
            controlPersisCiud.edit(ciudadano);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarTurno(Turno turno) {
        try {
            controlPersisTurn.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarCiudadano(Long id) {
        try {
            controlPersisCiud.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarTurno(Integer numero) {
        try {
            controlPersisTurn.destroy(numero);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
