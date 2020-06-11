package ec.gob.dinardap.seguridad.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.seguridad.dao.AsignacionInstitucionDao;
import ec.gob.dinardap.seguridad.modelo.AsignacionInstitucion;
import ec.gob.dinardap.seguridad.servicio.AsignacionInstitucionServicio;

@Stateless(name="AsignacionInstitucionServicio")
public class AsignacionInstitucionoServicioImpl extends GenericServiceImpl<AsignacionInstitucion, Integer>
		implements AsignacionInstitucionServicio {

	@EJB
	private AsignacionInstitucionDao asignacionInstitucionDao;
	
	@Override
	public GenericDao<AsignacionInstitucion, Integer> getDao() {
		return asignacionInstitucionDao;
	}

}
