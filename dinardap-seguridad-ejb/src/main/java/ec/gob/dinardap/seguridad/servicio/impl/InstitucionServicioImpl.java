package ec.gob.dinardap.seguridad.servicio.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.geografico.modelo.Canton;
import ec.gob.dinardap.persistence.constante.CriteriaTypeEnum;
import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.persistence.util.Criteria;
import ec.gob.dinardap.seguridad.dao.InstitucionDao;
import ec.gob.dinardap.seguridad.dto.InstitucionDto;
import ec.gob.dinardap.seguridad.modelo.Institucion;
import ec.gob.dinardap.seguridad.modelo.TipoInstitucion;
import ec.gob.dinardap.seguridad.servicio.InstitucionServicio;
import ec.gob.dinardap.util.constante.EstadoEnum;

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
	
	@Override
	public Institucion buscarInsttucionPorRuc(String ruc) {
		String[] criteriaNombres = {"ruc"};
		CriteriaTypeEnum[] criteriaTipos = {CriteriaTypeEnum.STRING_EQUALS};
		Object[] criteriaValores = {ruc};
		
		Criteria criteria = new Criteria(criteriaNombres, criteriaTipos, criteriaValores);
		List<Institucion> lista = new ArrayList<Institucion>();
		lista = findByCriterias(criteria);
		if(lista != null && lista.size() > 0)
			return lista.get(0);
		else
			return null;
	}
	
	@Override
	public List<Institucion> buscarInstitucionPorTipo(Integer tipoInstitucionId) {
		String[] criteriaNombres = {"tipoInstitucion.tipoInstitucionId", "estado"};
		CriteriaTypeEnum[] criteriaTipos = {CriteriaTypeEnum.INTEGER_EQUALS, CriteriaTypeEnum.SHORT_EQUALS};
		Object[] criteriaValores = {tipoInstitucionId, EstadoEnum.ACTIVO.getEstado()};
		String[] orderBy = {"nombre"};
        boolean[] asc = {true};
		
		Criteria criteria = new Criteria(criteriaNombres, criteriaTipos, criteriaValores, orderBy, asc);
		return findByCriterias(criteria);
	}
	
	@Override
	public boolean guardarInstitucion(InstitucionDto institucionDto) {
		Institucion institucion = new Institucion();
		institucion.setCanton(new Canton());
		institucion.setTipoInstitucion(new TipoInstitucion());
		institucion.setRuc(institucionDto.getRuc());
		institucion.setNombre(institucionDto.getNombre());
		institucion.setSiglas(institucionDto.getSiglas());
		institucion.setCodigoIs(institucionDto.getCodigoIs());
		institucion.getCanton().setCantonId(institucionDto.getCantonId());
		institucion.getTipoInstitucion().setTipoInstitucionId(institucionDto.getTipoInstitucionId());
		institucion.setEstado(EstadoEnum.ACTIVO.getEstado());
		if(institucionDto.getAdscrita() != null) {
			institucion.setInstitucion(new Institucion());
			institucion.getInstitucion().setInstitucionId(institucionDto.getAdscrita());
		}
		institucion.setFechaRegistro(new Timestamp (new Date().getTime()));
		create(institucion);
		if(institucion.getInstitucionId() != null)
			return true;
		else
			return false;
	}

}
