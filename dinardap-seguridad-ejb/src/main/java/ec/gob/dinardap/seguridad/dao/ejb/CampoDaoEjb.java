package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.seguridad.dao.CampoDao;
import ec.gob.dinardap.seguridad.modelo.Campo;

@Stateless(name="CampoDao")
public class CampoDaoEjb extends SeguridadGenericDao<Campo, Integer> implements CampoDao {

	public CampoDaoEjb() {
		super(Campo.class);
	}

}
