package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.ParametroDao;
import ec.gob.dinardap.seguridad.modelo.Parametro;

@Stateless(name="ParametroDao")
public class ParametroDaoEjb extends GenericDaoEjb<Parametro, String> implements ParametroDao {

	public ParametroDaoEjb() {
		super(Parametro.class);
	}

}
