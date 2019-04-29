package ec.gob.dinardap.seguridad.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.seguridad.dao.PermisoDao;
import ec.gob.dinardap.seguridad.modelo.Permiso;
import ec.gob.dinardap.seguridad.servicio.PermisoServicio;

@Stateless(name="PermisoServicio")
public class PermisoServicioImpl extends GenericServiceImpl<Permiso, Integer> implements PermisoServicio {

	@EJB
	private PermisoDao permisoDao;
	
	@Override
	public GenericDao<Permiso, Integer> getDao() {
		return permisoDao;
	}

}
