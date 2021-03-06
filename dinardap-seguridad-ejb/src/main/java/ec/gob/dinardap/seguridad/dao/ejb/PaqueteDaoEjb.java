package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.PaqueteDao;
import ec.gob.dinardap.seguridad.modelo.Paquete;

@Stateless(name="PaqueteDao")
public class PaqueteDaoEjb extends GenericDaoEjb<Paquete, Integer> implements PaqueteDao {

	public PaqueteDaoEjb() {
		super(Paquete.class);
	}

}
