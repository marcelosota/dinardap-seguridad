package ec.gob.dinardap.seguridad.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.seguridad.dao.AsignacionUsuarioDao;
import ec.gob.dinardap.seguridad.modelo.AsignacionUsuario;
import ec.gob.dinardap.seguridad.servicio.AsignacionUsuarioServicio;

@Stateless(name="AsignacionUsuarioServicio")
public class AsignacionUsuarioServicioImpl extends GenericServiceImpl<AsignacionUsuario, Integer>
		implements AsignacionUsuarioServicio {

	@EJB
	private AsignacionUsuarioDao asignacionUsuarioDao;
	
	@Override
	public GenericDao<AsignacionUsuario, Integer> getDao() {
		return asignacionUsuarioDao;
	}

}
