package ec.gob.dinardap.seguridad.servicio;

import javax.ejb.Local;

import ec.gob.dinardap.persistence.servicio.GenericService;
import ec.gob.dinardap.seguridad.modelo.Notificacion;

@Local
public interface NotificacionServicio extends GenericService<Notificacion, Integer> {

	public Notificacion getPorInstitucionSistema(Integer institucionId, Integer sistemaId);
}
