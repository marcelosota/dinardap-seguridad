package ec.gob.dinardap.seguridad.servicio;

import javax.ejb.Local;

import ec.gob.dinardap.persistence.servicio.GenericService;
import ec.gob.dinardap.seguridad.modelo.Perfil;

@Local
public interface PerfilServicio extends GenericService<Perfil, Integer> {

}
