package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.FuenteDao;
import ec.gob.dinardap.seguridad.modelo.Fuente;

@Stateless(name="FuenteDao")
public class FuenteDaoEjb extends GenericDaoEjb<Fuente, Integer> implements FuenteDao {

	public FuenteDaoEjb() {
		super(Fuente.class);
	}

}
