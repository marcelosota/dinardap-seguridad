package ec.gob.dinardap.seguridad.dao;

import javax.ejb.Local;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.seguridad.modelo.Asignacion;

@Local
public interface AsignacionDao extends GenericDao<Asignacion, Integer> {

}
