package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.InstitucionDao;
import ec.gob.dinardap.seguridad.modelo.AsignacionInstitucion;
import ec.gob.dinardap.seguridad.modelo.Institucion;
import ec.gob.dinardap.seguridad.modelo.UsuarioPerfil;
import ec.gob.dinardap.util.constante.EstadoEnum;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

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

    @SuppressWarnings("unchecked")
    @Override
    public List<Institucion> obtenerHijosPorInstitucion(List<Integer> institucionIdList, Integer tipoInstitucion) {
        Query query = em.createQuery("SELECT i FROM Institucion i WHERE i.tipoInstitucion.tipoInstitucionId = :tipoInstitucion AND i.estado = :estado AND i.institucion.institucionId IN (:institucionIdList)");
        query.setParameter("tipoInstitucion", tipoInstitucion);
        query.setParameter("estado",EstadoEnum.ACTIVO.getEstado());
        query.setParameter("institucionIdList", institucionIdList);
        return query.getResultList();
    }

    @Override
    public List<Institucion> obtenerInstitucionesActivasSistema(Integer sistemaId) {
        List<UsuarioPerfil> usuarioPerfilList = new ArrayList<UsuarioPerfil>();
        Query query = em.createQuery("SELECT up FROM UsuarioPerfil up INNER JOIN up.usuario.asignacionInstitucions ai WHERE up.perfil.sistema.sistemaId=:sistemaId AND ai.institucion.estado=:estado");
        query.setParameter("sistemaId", sistemaId);
        query.setParameter("estado",EstadoEnum.ACTIVO.getEstado());
        usuarioPerfilList = query.getResultList();
        List<Institucion> institucionList = new ArrayList<Institucion>();
        for(UsuarioPerfil usuarioPerfil:usuarioPerfilList){
            for(AsignacionInstitucion asignacionInstitucion:usuarioPerfil.getUsuario().getAsignacionInstitucions()){
                asignacionInstitucion.getInstitucion().getInstitucionId();
                institucionList.add(asignacionInstitucion.getInstitucion());
            }            
        }
        return institucionList;
    }

}
