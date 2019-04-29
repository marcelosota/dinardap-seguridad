package ec.gob.dinardap.seguridad.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.constante.CriteriaTypeEnum;
import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.persistence.util.Criteria;
import ec.gob.dinardap.seguridad.dao.ParametroDao;
import ec.gob.dinardap.seguridad.modelo.Parametro;
import ec.gob.dinardap.seguridad.servicio.ParametroServicio;

@Stateless(name="ParametroServicio")
public class ParametroServicioImpl extends GenericServiceImpl<Parametro, String> implements ParametroServicio {

	@EJB
	private ParametroDao parametroDao;
	
	@Override
	public GenericDao<Parametro, String> getDao() {
		return parametroDao;
	}
	
	@Override
	public Parametro obtenerParametro(String nombre) {
		String[] criteriaNombres = {"nombre"};
		CriteriaTypeEnum[] criteriaTipos = {CriteriaTypeEnum.STRING_EQUALS};
		Object[] criteriaValores = {nombre};
		
		Criteria criteria = new Criteria(criteriaNombres, criteriaTipos, criteriaValores);
		
		List<Parametro> lista = findByCriterias(criteria);
		if(lista != null && !lista.isEmpty())
			return lista.get(0);
		return null;
	}

}
