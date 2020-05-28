package ec.gob.dinardap.seguridad.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.seguridad.dao.PreguntaDao;
import ec.gob.dinardap.seguridad.modelo.Pregunta;
import ec.gob.dinardap.seguridad.servicio.PreguntaServicio;

@Stateless(name="PreguntaServicio")
public class PreguntaServicioImpl extends GenericServiceImpl<Pregunta, Integer> implements PreguntaServicio {

	@EJB
	private PreguntaDao preguntaDao;
	@Override
	public GenericDao<Pregunta, Integer> getDao() {
		return preguntaDao;
	}

}
