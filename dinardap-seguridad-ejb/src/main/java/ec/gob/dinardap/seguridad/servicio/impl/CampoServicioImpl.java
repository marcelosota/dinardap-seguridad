package ec.gob.dinardap.seguridad.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.seguridad.dao.CampoDao;
import ec.gob.dinardap.seguridad.modelo.Campo;
import ec.gob.dinardap.seguridad.servicio.CampoServicio;

@Stateless(name="CampoServicio")
public class CampoServicioImpl extends GenericServiceImpl<Campo, Integer> implements CampoServicio {

	@EJB
	private CampoDao campoDao;
	
	@Override
	public GenericDao<Campo, Integer> getDao() {
		return campoDao;
	}

}
