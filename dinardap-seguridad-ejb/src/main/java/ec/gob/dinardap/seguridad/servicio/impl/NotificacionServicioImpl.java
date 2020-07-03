package ec.gob.dinardap.seguridad.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.constante.CriteriaTypeEnum;
import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.persistence.util.Criteria;
import ec.gob.dinardap.seguridad.dao.NotificacionDao;
import ec.gob.dinardap.seguridad.modelo.Notificacion;
import ec.gob.dinardap.seguridad.servicio.NotificacionServicio;
import ec.gob.dinardap.util.constante.EstadoEnum;

@Stateless(name="NotificacionServicio")
public class NotificacionServicioImpl extends GenericServiceImpl<Notificacion, Integer>
		implements NotificacionServicio {

	@EJB
	private NotificacionDao notificacionDao;
	
	@Override
	public GenericDao<Notificacion, Integer> getDao() {
		return notificacionDao;
	}

	@Override
	public Notificacion getPorInstitucionSistema(Integer institucionId, Integer sistemaId) {
		String[] criteriaNombres = {"institucion.institucionId", "sistema.sistemaId"};
		CriteriaTypeEnum[] criteriaTipos = {CriteriaTypeEnum.INTEGER_EQUALS, CriteriaTypeEnum.INTEGER_EQUALS, CriteriaTypeEnum.SHORT_EQUALS};
		Object[] criteriaValores = {institucionId, sistemaId, EstadoEnum.ACTIVO.getEstado()};
		
		Criteria criteria = new Criteria(criteriaNombres, criteriaTipos, criteriaValores);
		List<Notificacion> lista = new ArrayList<Notificacion>(); 
		lista = findByCriterias(criteria);
		if(lista != null && lista.size() > 0)
			return lista.get(0);
		else
			return null;
	}

}
