package ec.gob.dinardap.seguridad.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.seguridad.dao.PaqueteDao;
import ec.gob.dinardap.seguridad.modelo.Paquete;
import ec.gob.dinardap.seguridad.servicio.PaqueteServicio;

@Stateless(name="PaqueteServicio")
public class PaqueteServicioImpl extends GenericServiceImpl<Paquete, Integer> implements PaqueteServicio {

	@EJB
	private PaqueteDao paqueteDao;
	
	@Override
	public GenericDao<Paquete, Integer> getDao() {
		return paqueteDao;
	}

}
