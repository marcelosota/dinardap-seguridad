package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.NotificacionDao;
import ec.gob.dinardap.seguridad.modelo.Notificacion;

@Stateless(name="NotificacionDao")
public class NotificacionDaoEjb extends GenericDaoEjb<Notificacion, Integer> implements NotificacionDao {

	public NotificacionDaoEjb() {
		super(Notificacion.class);
	}

}
