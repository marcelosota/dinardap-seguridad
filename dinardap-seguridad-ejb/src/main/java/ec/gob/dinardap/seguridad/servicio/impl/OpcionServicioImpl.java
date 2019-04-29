package ec.gob.dinardap.seguridad.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.seguridad.dao.OpcionDao;
import ec.gob.dinardap.seguridad.modelo.Opcion;
import ec.gob.dinardap.seguridad.servicio.OpcionServicio;

@Stateless(name="OpcionServicio")
public class OpcionServicioImpl extends GenericServiceImpl<Opcion, Integer> implements OpcionServicio {

	@EJB
	private OpcionDao opcionDao;
	@Override
	public GenericDao<Opcion, Integer> getDao() {
		return opcionDao;
	}

}
