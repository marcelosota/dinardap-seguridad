package ec.gob.dinardap.seguridad.dao;

import java.util.List;

import javax.ejb.Local;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.seguridad.modelo.Opcion;

@Local
public interface OpcionDao extends GenericDao<Opcion, Integer> {

	public List<Opcion> obtenerOpcionesPorPerfil1(String misPerfiles);
	public List<Opcion> obtenerOpciones(int perfilId);
	public List<Opcion> obtenerOpciones(List<String> perfil);
	public List<Opcion> obtenerOpcionesPerfilId(List<String> perfil);
}
