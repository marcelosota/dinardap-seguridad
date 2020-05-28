package ec.gob.dinardap.seguridad.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.seguridad.dao.TipoInstitucionDao;
import ec.gob.dinardap.seguridad.modelo.TipoInstitucion;
import ec.gob.dinardap.seguridad.servicio.TipoInstitucionServicio;

@Stateless(name="TipoInstitucionServicio")
public class TipoInstitucionServicioImpl extends GenericServiceImpl<TipoInstitucion, Integer>
		implements TipoInstitucionServicio {

	@EJB
	private TipoInstitucionDao tipoInstitucionDao;
	@Override
	public GenericDao<TipoInstitucion, Integer> getDao() {
		return tipoInstitucionDao;
	}

}
