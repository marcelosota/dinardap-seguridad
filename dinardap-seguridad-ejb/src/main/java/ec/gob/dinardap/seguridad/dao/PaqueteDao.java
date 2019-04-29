package ec.gob.dinardap.seguridad.dao;

import javax.ejb.Local;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.seguridad.modelo.Paquete;

@Local
public interface PaqueteDao extends GenericDao<Paquete, Integer> {

}
