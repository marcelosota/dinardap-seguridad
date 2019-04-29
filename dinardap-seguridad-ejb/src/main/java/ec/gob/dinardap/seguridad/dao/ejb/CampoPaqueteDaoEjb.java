package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.seguridad.dao.CampoPaqueteDao;
import ec.gob.dinardap.seguridad.modelo.CampoPaquete;

@Stateless(name="CampoPaqueteDao")
public class CampoPaqueteDaoEjb extends SeguridadGenericDao<CampoPaquete, Integer>
		implements CampoPaqueteDao {

	public CampoPaqueteDaoEjb() {
		super(CampoPaquete.class);
	}
}
