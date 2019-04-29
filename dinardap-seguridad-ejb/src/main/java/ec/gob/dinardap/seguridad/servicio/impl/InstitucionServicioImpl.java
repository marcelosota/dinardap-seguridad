package ec.gob.dinardap.seguridad.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.seguridad.dao.InstitucionDao;
import ec.gob.dinardap.seguridad.modelo.Institucion;
import ec.gob.dinardap.seguridad.servicio.InstitucionServicio;

@Stateless(name="InstitucionServicio")
public class InstitucionServicioImpl extends GenericServiceImpl<Institucion, Integer> implements InstitucionServicio {

	@EJB
	private InstitucionDao institucionDao;
	@Override
	public GenericDao<Institucion, Integer> getDao() {
		return institucionDao;
	}

}
