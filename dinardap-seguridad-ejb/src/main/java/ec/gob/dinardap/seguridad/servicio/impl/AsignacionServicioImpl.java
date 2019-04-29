package ec.gob.dinardap.seguridad.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.seguridad.dao.AsignacionDao;
import ec.gob.dinardap.seguridad.modelo.Asignacion;
import ec.gob.dinardap.seguridad.servicio.AsignacionServicio;

@Stateless(name="AsiganacionServicio")
public class AsignacionServicioImpl extends GenericServiceImpl<Asignacion, Integer> implements AsignacionServicio {

	@EJB
	private AsignacionDao asignacionDao;
	
	@Override
	public GenericDao<Asignacion, Integer> getDao() {
		return asignacionDao;
	}

}
