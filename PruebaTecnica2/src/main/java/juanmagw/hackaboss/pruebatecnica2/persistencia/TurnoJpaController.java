package juanmagw.hackaboss.pruebatecnica2.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import juanmagw.hackaboss.pruebatecnica2.logica.Ciudadano;
import juanmagw.hackaboss.pruebatecnica2.logica.Turno;
import juanmagw.hackaboss.pruebatecnica2.persistencia.exceptions.NonexistentEntityException;

public class TurnoJpaController implements Serializable {

    public TurnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public TurnoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("turnosPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Turno turno) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ciudadano ciudadano = turno.getCiudadano();
            if (ciudadano != null) {
                ciudadano = em.getReference(ciudadano.getClass(), ciudadano.getId());
                turno.setCiudadano(ciudadano);
            }
            em.persist(turno);
            if (ciudadano != null) {
                ciudadano.getTurnos().add(turno);
                ciudadano = em.merge(ciudadano);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Turno turno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno persistentTurno = em.find(Turno.class, turno.getNumero());
            Ciudadano ciudadanoOld = persistentTurno.getCiudadano();
            Ciudadano ciudadanoNew = turno.getCiudadano();
            if (ciudadanoNew != null) {
                ciudadanoNew = em.getReference(ciudadanoNew.getClass(), ciudadanoNew.getId());
                turno.setCiudadano(ciudadanoNew);
            }
            turno = em.merge(turno);
            if (ciudadanoOld != null && !ciudadanoOld.equals(ciudadanoNew)) {
                ciudadanoOld.getTurnos().remove(turno);
                ciudadanoOld = em.merge(ciudadanoOld);
            }
            if (ciudadanoNew != null && !ciudadanoNew.equals(ciudadanoOld)) {
                ciudadanoNew.getTurnos().add(turno);
                ciudadanoNew = em.merge(ciudadanoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = turno.getNumero();
                if (findTurno(id) == null) {
                    throw new NonexistentEntityException("The turno with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno turno;
            try {
                turno = em.getReference(Turno.class, id);
                turno.getNumero();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turno with id " + id + " no longer exists.", enfe);
            }
            Ciudadano ciudadano = turno.getCiudadano();
            if (ciudadano != null) {
                ciudadano.getTurnos().remove(turno);
                ciudadano = em.merge(ciudadano);
            }
            em.remove(turno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Turno> findTurnoEntities() {
        return findTurnoEntities(true, -1, -1);
    }

    public List<Turno> findTurnoEntities(int maxResults, int firstResult) {
        return findTurnoEntities(false, maxResults, firstResult);
    }

    private List<Turno> findTurnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Turno.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Turno findTurno(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turno.class, id);
        } finally {
            em.close();
        }
    }

    public int getTurnoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Turno> rt = cq.from(Turno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
