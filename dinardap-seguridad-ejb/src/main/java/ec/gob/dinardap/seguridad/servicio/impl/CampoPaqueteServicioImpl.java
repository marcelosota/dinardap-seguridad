package ec.gob.dinardap.seguridad.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.seguridad.dao.CampoPaqueteDao;
import ec.gob.dinardap.seguridad.modelo.CampoPaquete;
import ec.gob.dinardap.seguridad.servicio.CampoPaqueteServicio;

@Stateless(name="CampoPaqueteServicio")
public class CampoPaqueteServicioImpl extends GenericServiceImpl<CampoPaquete, Integer>
		implements CampoPaqueteServicio {

	@EJB
	private CampoPaqueteDao campoPaqueteServicio;
	
	@Override
	public GenericDao<CampoPaquete, Integer> getDao() {
		return campoPaqueteServicio;
	}

}
