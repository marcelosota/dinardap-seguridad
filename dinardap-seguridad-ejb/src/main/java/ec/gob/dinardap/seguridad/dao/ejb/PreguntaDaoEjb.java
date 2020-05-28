package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.PreguntaDao;
import ec.gob.dinardap.seguridad.modelo.Pregunta;

@Stateless(name="PreguntaDao")
public class PreguntaDaoEjb extends GenericDaoEjb<Pregunta, Integer> implements PreguntaDao {

	public PreguntaDaoEjb() {
		super(Pregunta.class);
	}

}
