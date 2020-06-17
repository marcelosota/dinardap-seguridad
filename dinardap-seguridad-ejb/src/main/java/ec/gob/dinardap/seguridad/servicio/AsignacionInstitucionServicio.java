package ec.gob.dinardap.seguridad.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.gob.dinardap.persistence.servicio.GenericService;
import ec.gob.dinardap.seguridad.dto.UsuarioInstitucionDto;
import ec.gob.dinardap.seguridad.modelo.AsignacionInstitucion;

@Local
public interface AsignacionInstitucionServicio extends GenericService<AsignacionInstitucion, Integer> {

	public void asignarUsuarioInstitucion(Integer usuarioId, Integer institucionId);
	public List<UsuarioInstitucionDto> buscarAsignacionesPorUsuario(Integer usuarioId);
	public boolean verificarAsignacionPorEstado(Integer usuarioId, Short estado);
	public void actualizarAsignacion(UsuarioInstitucionDto usuarioInstitucionDto);
}
