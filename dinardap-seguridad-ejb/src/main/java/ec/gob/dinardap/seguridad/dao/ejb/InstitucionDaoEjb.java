package ec.gob.dinardap.seguridad.dao.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.InstitucionDao;
import ec.gob.dinardap.seguridad.modelo.Institucion;

@Stateless(name = "InstitucionDao")
public class InstitucionDaoEjb extends GenericDaoEjb<Institucion, Integer> implements InstitucionDao {

    public InstitucionDaoEjb() {
        super(Institucion.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Institucion> obtenerInstitucionPorCantonEstado(Integer cantonId, Short estado, List<Integer> tipoInstitucionId) {
        Query query = em.createQuery("SELECT i FROM Institucion i WHERE i.canton.cantonId = :cantonId AND i.estado=:estado AND i.tipoInstitucion.tipoInstitucionId IN (:tipoInstitucionId)");
        query.setParameter("cantonId", cantonId);
        query.setParameter("estado", estado);
        query.setParameter("tipoInstitucionId", tipoInstitucionId);
        return query.getResultList();
    }

}
