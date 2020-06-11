package ec.gob.dinardap.seguridad.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.constante.CriteriaTypeEnum;
import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.persistence.util.Criteria;
import ec.gob.dinardap.seguridad.dao.TipoInstitucionDao;
import ec.gob.dinardap.seguridad.modelo.TipoInstitucion;
import ec.gob.dinardap.seguridad.servicio.TipoInstitucionServicio;
import ec.gob.dinardap.util.constante.EstadoEnum;

@Stateless(name="TipoInstitucionServicio")
public class TipoInstitucionServicioImpl extends GenericServiceImpl<TipoInstitucion, Integer>
		implements TipoInstitucionServicio {

	@EJB
	private TipoInstitucionDao tipoInstitucionDao;
	@Override
	public GenericDao<TipoInstitucion, Integer> getDao() {
		return tipoInstitucionDao;
	}
	
	@Override
	public List<TipoInstitucion> tipoInstitucionActivas() {
		String[] criteriaNombres = {"estado"};
		CriteriaTypeEnum[] criteriaTipos = {CriteriaTypeEnum.SHORT_EQUALS};
		Object[] criteriaValores = {EstadoEnum.ACTIVO.getEstado()};
		String[] orderBy = {"descripcion"};
		boolean[] asc = {true};
		
		Criteria criteria = new Criteria(criteriaNombres, criteriaTipos, criteriaValores, orderBy, asc);
		return findByCriterias(criteria);
	}

}
