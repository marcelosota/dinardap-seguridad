package ec.gob.dinardap.seguridad.servicio.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.constante.CriteriaTypeEnum;
import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.persistence.util.Criteria;
import ec.gob.dinardap.seguridad.dao.AsignacionInstitucionDao;
import ec.gob.dinardap.seguridad.dto.UsuarioInstitucionDto;
import ec.gob.dinardap.seguridad.modelo.AsignacionInstitucion;
import ec.gob.dinardap.seguridad.servicio.AsignacionInstitucionServicio;
import ec.gob.dinardap.seguridad.servicio.InstitucionServicio;
import ec.gob.dinardap.seguridad.servicio.UsuarioServicio;
import ec.gob.dinardap.util.constante.EstadoEnum;

@Stateless(name="AsignacionInstitucionServicio")
public class AsignacionInstitucionoServicioImpl extends GenericServiceImpl<AsignacionInstitucion, Integer>
		implements AsignacionInstitucionServicio {

	@EJB
	private AsignacionInstitucionDao asignacionInstitucionDao;
	
	@EJB 
	private UsuarioServicio usuarioServicio;
	
	@EJB
	private InstitucionServicio institucionServicio;
	
	@Override
	public GenericDao<AsignacionInstitucion, Integer> getDao() {
		return asignacionInstitucionDao;
	}

	@Override
	public void asignarUsuarioInstitucion(Integer usuarioId, Integer institucionId) {
		AsignacionInstitucion asignacion = new AsignacionInstitucion();
		asignacion.setUsuario(usuarioServicio.findByPk(usuarioId));
		asignacion.setInstitucion(institucionServicio.findByPk(institucionId));
		asignacion.setEstado(EstadoEnum.ACTIVO.getEstado());
		asignacion.setFechaCreacion(new Timestamp (new Date().getTime()));
		create(asignacion);
	}

	@Override
	public List<UsuarioInstitucionDto> buscarAsignacionesPorUsuario(Integer usuarioId) {
		List<UsuarioInstitucionDto> asg = new ArrayList<UsuarioInstitucionDto>();
		String[] criteriaNombres = {"usuario.usuarioId"};
		CriteriaTypeEnum[] criteriaTipos = {CriteriaTypeEnum.INTEGER_EQUALS};
		Object[] criteriaValores = {usuarioId};
		String[] orderBy = {"estado"};
		boolean[] asc = {true}; 
		
		Criteria criteria = new Criteria(criteriaNombres, criteriaTipos, criteriaValores, orderBy, asc);
		List<AsignacionInstitucion> lista = findByCriterias(criteria);
		if(lista != null && lista.size() > 0) 
			for(AsignacionInstitucion item : lista) {
				UsuarioInstitucionDto fila = new UsuarioInstitucionDto();
				fila.setAsignacionInstitucionId(item.getAsignacionInstitucionId());
				fila.setRuc(item.getInstitucion().getRuc());
				fila.setNombre(item.getInstitucion().getNombre());
				fila.setSiglas(item.getInstitucion().getSiglas());
				fila.setFechaCreacion(item.getFechaCreacion());
				if(item.getEstado() == EstadoEnum.ACTIVO.getEstado())
					fila.setEstado(Boolean.TRUE);
				else
					fila.setEstado(Boolean.FALSE);
				asg.add(fila);
			}
		return asg;
	}

	@Override
	public boolean verificarAsignacionPorEstado(Integer usuarioId, Short estado) {
		String[] criteriaNombres = {"usuario.usuarioId", "estado"};
		CriteriaTypeEnum[] criteriaTipos = {CriteriaTypeEnum.INTEGER_EQUALS, CriteriaTypeEnum.SHORT_EQUALS};
		Object[] criteriaValores = {usuarioId, estado};
		
		Criteria criteria = new Criteria(criteriaNombres, criteriaTipos, criteriaValores);
		List<AsignacionInstitucion> lista = findByCriterias(criteria);
		if(lista != null && lista.size() > 0) 
			return true;
		else
			return false;
	}

	@Override
	public void actualizarAsignacion(UsuarioInstitucionDto usuarioInstitucionDto) {
		AsignacionInstitucion asignacion = findByPk(usuarioInstitucionDto.getAsignacionInstitucionId());
		if(usuarioInstitucionDto.getEstado())
			asignacion.setEstado(EstadoEnum.ACTIVO.getEstado());
		else
			asignacion.setEstado(EstadoEnum.INACTIVO.getEstado());
		asignacion.setFechaModificacion(new Timestamp (new Date().getTime()));
		update(asignacion);
	}

}
