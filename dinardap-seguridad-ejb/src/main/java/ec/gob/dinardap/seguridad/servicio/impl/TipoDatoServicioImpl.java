package ec.gob.dinardap.seguridad.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.seguridad.dao.TipoDatoDao;
import ec.gob.dinardap.seguridad.modelo.TipoDato;
import ec.gob.dinardap.seguridad.servicio.TipoDatoServicio;

@Stateless(name="TipoDatoServicio")
public class TipoDatoServicioImpl extends GenericServiceImpl<TipoDato, Short> implements TipoDatoServicio {

	@EJB
	private TipoDatoDao tipoDatoDao;

	@Override
	public GenericDao<TipoDato, Short> getDao() {
		return tipoDatoDao;
	}

}
