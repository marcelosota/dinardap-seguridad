package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.PreguntaDao;
import ec.gob.dinardap.seguridad.modelo.Pregunta;
import ec.gob.dinardap.util.constante.EstadoEnum;
import java.util.List;
import javax.persistence.Query;

@Stateless(name="PreguntaDao")
public class PreguntaDaoEjb extends GenericDaoEjb<Pregunta, Integer> implements PreguntaDao {

	public PreguntaDaoEjb() {
		super(Pregunta.class);
	}

    @Override
    public List<Pregunta> obtenerPreguntasActivas() {
        Query query = em.createQuery("SELECT p FROM Pregunta p WHERE p.estado=:estado");
        query.setParameter("estado",EstadoEnum.ACTIVO.getEstado());
        return query.getResultList();
    }

}
