package ec.gob.dinardap.seguridad.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.seguridad.dao.FuenteDao;
import ec.gob.dinardap.seguridad.modelo.Fuente;
import ec.gob.dinardap.seguridad.servicio.FuenteServicio;

@Stateless(name="FuenteServicio")
public class FuenteServicioImpl extends GenericServiceImpl<Fuente, Integer> implements FuenteServicio {

	@EJB
	private FuenteDao fuenteDao;
	
	@Override
	public GenericDao<Fuente, Integer> getDao() {
		return fuenteDao;
	}

}
