package ec.gob.dinardap.seguridad.dao;

import javax.ejb.Local;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.seguridad.dto.ValidacionDto;
import ec.gob.dinardap.seguridad.modelo.Usuario;

@Local
public interface UsuarioDao extends GenericDao<Usuario, Integer> {

	public ValidacionDto validarUsuario(String identificacion, String contrasena, Integer sistemaId);
	public ValidacionDto validarUsuarioArreglo(String identificacion, String contrasena, Integer sistemaId);
}
