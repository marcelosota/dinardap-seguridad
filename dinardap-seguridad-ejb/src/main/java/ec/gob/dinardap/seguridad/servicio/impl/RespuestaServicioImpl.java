package ec.gob.dinardap.seguridad.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.seguridad.dao.RespuestaDao;
import ec.gob.dinardap.seguridad.modelo.Respuesta;
import ec.gob.dinardap.seguridad.servicio.RespuestaServicio;

@Stateless(name="RespuestaServicio")
public class RespuestaServicioImpl extends GenericServiceImpl<Respuesta, Integer> implements RespuestaServicio {

	@EJB
	private RespuestaDao respuestaDao;
	
	@Override
	public GenericDao<Respuesta, Integer> getDao() {
		return respuestaDao;
	}

}
