package ec.gob.dinardap.seguridad.servicio;

import javax.ejb.Local;

import ec.gob.dinardap.persistence.servicio.GenericService;
import ec.gob.dinardap.seguridad.modelo.Opcion;

@Local
public interface OpcionServicio extends GenericService<Opcion, Integer> {

}
