package ec.gob.dinardap.seguridad.servicio;

import javax.ejb.Local;

import ec.gob.dinardap.persistence.servicio.GenericService;
import ec.gob.dinardap.seguridad.modelo.TipoDato;

@Local
public interface TipoDatoServicio extends GenericService<TipoDato, Short> {

}
