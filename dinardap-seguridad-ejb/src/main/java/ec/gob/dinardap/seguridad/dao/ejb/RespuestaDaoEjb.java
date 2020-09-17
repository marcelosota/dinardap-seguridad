package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.RespuestaDao;
import ec.gob.dinardap.seguridad.modelo.Respuesta;

@Stateless(name="RespuestaDao")
public class RespuestaDaoEjb extends GenericDaoEjb<Respuesta, Integer> implements RespuestaDao {

	public RespuestaDaoEjb() {
		super(Respuesta.class);
	}

}
