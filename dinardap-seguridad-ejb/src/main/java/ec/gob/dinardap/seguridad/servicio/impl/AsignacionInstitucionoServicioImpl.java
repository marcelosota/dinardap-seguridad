package ec.gob.dinardap.seguridad.servicio.impl;

import java.sql.Timestamp;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.seguridad.dao.AsignacionInstitucionDao;
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
	public void asiganrUsuarioInstitucion(Integer usuarioId, Integer institucionId) {
		AsignacionInstitucion asignacion = new AsignacionInstitucion();
		asignacion.setUsuario(usuarioServicio.findByPk(usuarioId));
		asignacion.setInstitucion(institucionServicio.findByPk(institucionId));
		asignacion.setEstado(EstadoEnum.ACTIVO.getEstado());
		asignacion.setFechaCreacion(new Timestamp (new Date().getTime()));
		create(asignacion);
	}

}
