package ec.gob.dinardap.seguridad.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.gob.dinardap.persistence.servicio.GenericService;
import ec.gob.dinardap.seguridad.modelo.Perfil;

@Local
public interface PerfilServicio extends GenericService<Perfil, Integer> {

	public Perfil obtenerPorNombre(String nombre);
	public List<Perfil> obtenerPerfilesPorSistema(Integer sistemaId);
	public List<Perfil> obtenerPerfilesPorSistemaTipoPerfil(Integer sistemaId, short tipoPerfil);
}
