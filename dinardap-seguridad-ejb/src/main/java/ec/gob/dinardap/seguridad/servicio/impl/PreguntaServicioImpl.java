package ec.gob.dinardap.seguridad.servicio.impl;

import ec.gob.dinardap.persistence.constante.CriteriaTypeEnum;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.persistence.util.Criteria;
import ec.gob.dinardap.seguridad.dao.PreguntaDao;
import ec.gob.dinardap.seguridad.modelo.Pregunta;
import ec.gob.dinardap.seguridad.servicio.PreguntaServicio;
import ec.gob.dinardap.util.constante.EstadoEnum;
import java.util.List;

@Stateless(name = "PreguntaServicio")
public class PreguntaServicioImpl extends GenericServiceImpl<Pregunta, Integer> implements PreguntaServicio {

    @EJB
    private PreguntaDao preguntaDao;

    @Override
    public GenericDao<Pregunta, Integer> getDao() {
        return preguntaDao;
    }

    @Override
    public List<Pregunta> getPreguntasActivas() {
        String[] criteriaNombres = {"estado"};
        CriteriaTypeEnum[] criteriaTipos = {CriteriaTypeEnum.SHORT_EQUALS};
        Object[] criteriaValores = {EstadoEnum.ACTIVO.getEstado()};
        String[] orderBy = {"preguntaId"};
        boolean[] asc = {true};
        Criteria criteria = new Criteria(criteriaNombres, criteriaTipos, criteriaValores, orderBy, asc);
        return findByCriterias(criteria);
    }

}
