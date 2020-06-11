package ec.gob.dinardap.seguridad.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.gob.dinardap.persistence.servicio.GenericService;
import ec.gob.dinardap.seguridad.modelo.TipoInstitucion;

@Local
public interface TipoInstitucionServicio extends GenericService<TipoInstitucion, Integer> {

	public List<TipoInstitucion> tipoInstitucionActivas();
}
