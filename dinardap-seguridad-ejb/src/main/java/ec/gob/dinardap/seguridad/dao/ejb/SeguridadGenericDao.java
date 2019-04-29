package ec.gob.dinardap.seguridad.dao.ejb;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.gob.dinardap.persistence.dao.ejb.GenericEmDaoEjb;

public class SeguridadGenericDao<T, PK extends Serializable> extends GenericEmDaoEjb<T, PK> {
	/**
	 * @param type
	 */
	public SeguridadGenericDao(Class<T> type) {
		super(type);
	}

	@PersistenceContext(unitName = "seguridad-pu")
	protected EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.dinardap.persistence.dao.ejb.GenericEmDaoEjb#getEm()
	 */
	@Override
	protected EntityManager getEm() {
		return this.em;
	}
}