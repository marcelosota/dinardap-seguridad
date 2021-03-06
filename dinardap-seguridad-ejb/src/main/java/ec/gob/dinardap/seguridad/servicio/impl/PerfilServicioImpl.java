package ec.gob.dinardap.seguridad.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.constante.CriteriaTypeEnum;
import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.persistence.util.Criteria;
import ec.gob.dinardap.seguridad.dao.PerfilDao;
import ec.gob.dinardap.seguridad.modelo.Perfil;
import ec.gob.dinardap.seguridad.servicio.PerfilServicio;
import ec.gob.dinardap.util.constante.EstadoEnum;

@Stateless(name="PerfilServicio")
public class PerfilServicioImpl extends GenericServiceImpl<Perfil, Integer> implements PerfilServicio {

	@EJB
	private PerfilDao perfilDao;
	
	@Override
	public GenericDao<Perfil, Integer> getDao() {
		return perfilDao;
	}

	@Override
	public Perfil obtenerPorNombre(String nombre) {
		String[] criteriaNombres = {"nombre", "estado"};
		CriteriaTypeEnum[] criteriaTipos = {CriteriaTypeEnum.STRING_EQUALS, CriteriaTypeEnum.SHORT_EQUALS};
		Object[] criteriaValores = {nombre, EstadoEnum.ACTIVO.getEstado()};
		
		Criteria criteria = new Criteria(criteriaNombres, criteriaTipos, criteriaValores);
		List<Perfil> lista  = findByCriterias(criteria);
		if(lista != null && lista.size() == 1)
			return lista.get(0);
		else
			return null;
	}

	@Override
	public List<Perfil> obtenerPerfilesPorSistema(Integer sistemaId) {
		String[] criteriaNombres = {"sistema.sistemaId", "estado"};
		CriteriaTypeEnum[] criteriaTipos = {CriteriaTypeEnum.INTEGER_EQUALS, CriteriaTypeEnum.SHORT_EQUALS};
		Object[] criteriaValores = {sistemaId, EstadoEnum.ACTIVO.getEstado()};
		String[] orderBy = {"nombre"};
		boolean[] asc = {true}; 
		
		Criteria criteria = new Criteria(criteriaNombres, criteriaTipos, criteriaValores, orderBy, asc);
		return findByCriterias(criteria);
	}

	@Override
	public List<Perfil> obtenerPerfilesPorSistemaTipoPerfil(Integer sistemaId, short tipoPerfil) {
		String[] criteriaNombres = {"sistema.sistemaId", "tipo", "estado"};
		CriteriaTypeEnum[] criteriaTipos = {CriteriaTypeEnum.INTEGER_EQUALS, CriteriaTypeEnum.SHORT_EQUALS, CriteriaTypeEnum.SHORT_EQUALS};
		Object[] criteriaValores = {sistemaId, tipoPerfil, EstadoEnum.ACTIVO.getEstado()};
		String[] orderBy = {"nombre"};
		boolean[] asc = {true}; 
		
		Criteria criteria = new Criteria(criteriaNombres, criteriaTipos, criteriaValores, orderBy, asc);
		return findByCriterias(criteria);
	}

}
