package ec.gob.dinardap.seguridad.servicio;

import javax.ejb.Local;

import ec.gob.dinardap.persistence.servicio.GenericService;
import ec.gob.dinardap.seguridad.modelo.Paquete;

@Local
public interface PaqueteServicio extends GenericService<Paquete, Integer> {

}
