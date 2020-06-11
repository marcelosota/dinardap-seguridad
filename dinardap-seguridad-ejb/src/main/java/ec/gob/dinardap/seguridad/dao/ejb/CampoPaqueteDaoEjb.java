package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.CampoPaqueteDao;
import ec.gob.dinardap.seguridad.modelo.CampoPaquete;

@Stateless(name="CampoPaqueteDao")
public class CampoPaqueteDaoEjb extends GenericDaoEjb<CampoPaquete, Integer>
		implements CampoPaqueteDao {

	public CampoPaqueteDaoEjb() {
		super(CampoPaquete.class);
	}
}
