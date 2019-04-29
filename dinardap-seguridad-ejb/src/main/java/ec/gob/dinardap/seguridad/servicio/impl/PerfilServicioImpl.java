package ec.gob.dinardap.seguridad.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.seguridad.dao.PerfilDao;
import ec.gob.dinardap.seguridad.modelo.Perfil;
import ec.gob.dinardap.seguridad.servicio.PerfilServicio;

@Stateless(name="PerfilServicio")
public class PerfilServicioImpl extends GenericServiceImpl<Perfil, Integer> implements PerfilServicio {

	@EJB
	private PerfilDao perfilDao;
	
	@Override
	public GenericDao<Perfil, Integer> getDao() {
		return perfilDao;
	}

}
