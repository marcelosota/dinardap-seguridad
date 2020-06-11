package ec.gob.dinardap.seguridad.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.constante.CriteriaTypeEnum;
import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.persistence.util.Criteria;
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
	@Override
	public List<Institucion> obtenerInstitucionesTipoCantonEstado(Integer tipoInstitucionId, Integer cantonId, Short estado) {
		String[] criteriaNombres = {"tipoInstitucion.tipoInstitucionId", "canton.cantonId", "estado"};
		CriteriaTypeEnum[] criteriaTipos = {CriteriaTypeEnum.INTEGER_EQUALS, CriteriaTypeEnum.INTEGER_EQUALS, CriteriaTypeEnum.SHORT_EQUALS};
		Object[] criteriaValores = {tipoInstitucionId, cantonId, estado};
		String[] orderBy = {"nombre"};
        boolean[] asc = {true};
		
		Criteria criteria = new Criteria(criteriaNombres, criteriaTipos, criteriaValores, orderBy, asc);
		return findByCriterias(criteria);
	}

}
