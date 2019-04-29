package ec.gob.dinardap.seguridad.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.seguridad.dao.SistemaDao;
import ec.gob.dinardap.seguridad.modelo.Sistema;
import ec.gob.dinardap.seguridad.servicio.SistemaServicio;

@Stateless(name="SistemaServicio")
public class SistemaServicioImpl extends GenericServiceImpl<Sistema, Integer> implements SistemaServicio {

	@EJB
	private SistemaDao sistemaDao;
	
	@Override
	public GenericDao<Sistema, Integer> getDao() {
		return sistemaDao;
	}

}
