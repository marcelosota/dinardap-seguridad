package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.InstitucionDao;
import ec.gob.dinardap.seguridad.modelo.Institucion;

@Stateless(name="InstitucionDao")
public class InstitucionDaoEjb extends GenericDaoEjb<Institucion, Integer> implements InstitucionDao {

	public InstitucionDaoEjb() {
		super(Institucion.class);
	}

}
