package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.seguridad.dao.InstitucionDao;
import ec.gob.dinardap.seguridad.modelo.Institucion;

@Stateless(name="InstitucionDao")
public class InstitucionDaoEjb extends SeguridadGenericDao<Institucion, Integer> implements InstitucionDao {

	public InstitucionDaoEjb() {
		super(Institucion.class);
	}

}
