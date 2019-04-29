package ec.gob.dinardap.seguridad.servicio;

import javax.ejb.Local;

import ec.gob.dinardap.persistence.servicio.GenericService;
import ec.gob.dinardap.seguridad.modelo.Parametro;

@Local
public interface ParametroServicio extends GenericService<Parametro, String> {

	public Parametro obtenerParametro(String nombre);
}
