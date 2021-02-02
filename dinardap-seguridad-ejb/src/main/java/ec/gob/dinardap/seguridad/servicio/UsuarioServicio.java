package ec.gob.dinardap.seguridad.servicio;

import javax.ejb.Local;

import ec.gob.dinardap.persistence.servicio.GenericService;
import ec.gob.dinardap.seguridad.dto.UsuarioDto;
import ec.gob.dinardap.seguridad.dto.ValidacionDto;
import ec.gob.dinardap.seguridad.modelo.Usuario;

@Local
public interface UsuarioServicio extends GenericService<Usuario, Integer> {

    public Usuario obtenerUsuarioPorIdentificacion(String identificacion);

    public UsuarioDto crearUsuario(UsuarioDto usuarioDto);

    public Usuario crearUsuario(Usuario usuario);

    public void modificarUsuario(UsuarioDto usuarioDto);

    public ValidacionDto validarUsuario(String identificacion, String contrasena, Integer sistemaId);

    public void actualizarContrasena(String identificacion, String contrasena);

    public Usuario verificarCredenciales(String cedula, String contrasena);   
    
}
