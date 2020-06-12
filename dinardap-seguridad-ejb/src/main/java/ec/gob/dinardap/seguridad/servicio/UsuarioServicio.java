package ec.gob.dinardap.seguridad.servicio;

import javax.ejb.Local;

import ec.gob.dinardap.persistence.servicio.GenericService;
import ec.gob.dinardap.seguridad.dto.UsuarioDto;
import ec.gob.dinardap.seguridad.modelo.Usuario;

@Local
public interface UsuarioServicio extends GenericService<Usuario, Integer> {

	public Usuario obtenerUsuarioPorIdentificacion(String identificacion);
	public UsuarioDto crearUsuario(UsuarioDto usuarioDto);
}
