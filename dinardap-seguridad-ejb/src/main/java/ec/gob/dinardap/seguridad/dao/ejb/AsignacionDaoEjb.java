package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.seguridad.dao.AsignacionDao;
import ec.gob.dinardap.seguridad.modelo.Asignacion;

@Stateless(name="AsignacionDao")
public class AsignacionDaoEjb extends SeguridadGenericDao<Asignacion, Integer> implements AsignacionDao {

	public AsignacionDaoEjb() {
		super(Asignacion.class);
	}

}
