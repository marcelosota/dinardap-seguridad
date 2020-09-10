package ec.gob.dinardap.seguridad.dao.ejb;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.OpcionDao;
import ec.gob.dinardap.seguridad.modelo.Opcion;
import ec.gob.dinardap.util.constante.EstadoEnum;

@Stateless(name = "OpcionDao")
public class OpcionDaoEjb extends GenericDaoEjb<Opcion, Integer> implements OpcionDao {

    public OpcionDaoEjb() {
        super(Opcion.class);
    }

    /*@SuppressWarnings("unchecked")
    @Override
    public List<TramiteRegistradorDto> tramitesPendientes(Short estadoTramite, Integer institucionId) {
        Query query = em.createQuery("SELECT t FROM Tramite t where t.estado=:estado AND t.continuaTramite.institucionId=:institucionId");
        query.setParameter("estado", estadoTramite);
        query.setParameter("institucionId", institucionId);
        List<TramiteRegistradorDto> tramitesPendientes = new ArrayList<TramiteRegistradorDto>();
        List<Tramite> tramiteList = new ArrayList<Tramite>();
        if (!query.getResultList().isEmpty()) {
            tramiteList = query.getResultList();
            for (Tramite tramite : tramiteList) {
                TramiteRegistradorDto item = new TramiteRegistradorDto();
                item.setTramiteId(tramite.getTramiteId());
                item.setCodigo(tramite.getCodigo());
                item.setInstitucion(tramite.getInstitucion().getNombre());
                item.setDescripcionNotarial(tramite.getDescripcion());
                item.setRegistradoPor(tramite.getRegistradoPor().getNombre());
                item.setFechaRegistro(tramite.getFechaRegistro());
                tramitesPendientes.add(item);
            }
        }
        return tramitesPendientes;
    }*/
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Opcion> obtenerOpcionesPorPerfilArbol(List<String> misPerfiles) {
        List<Opcion> menu = new ArrayList<Opcion>();
        String separador = ",";
        String perfiles = String.join(separador, misPerfiles);
        StringBuilder sql = new StringBuilder("with recursive menu as( ");
        sql.append("select o.opcion_id, o.padre_id, o.nombre, o.url, o.nivel, o.orden, o.visible, o.estado ");
        sql.append("from ec_dinardap_seguridad.permiso p ");
        sql.append("inner join ec_dinardap_seguridad.opcion o on p.opcion_id = o.opcion_id ");
        sql.append("inner join ec_dinardap_seguridad.perfil f on f.perfil_id = p.perfil_id ");
        sql.append("where ");
        sql.append("p.perfil_id in( ").append(perfiles).append(") ");
        sql.append("and p.estado = ").append(EstadoEnum.ACTIVO.getEstado());
        sql.append(" and o.estado = ").append(EstadoEnum.ACTIVO.getEstado()).append(")");
        sql.append("select opcion_id, padre_id, nombre, url, nivel, orden, visible, estado ");
        sql.append("from menu ");
        sql.append("where visible = true ");

        Query query = em.createNativeQuery(sql.toString(), Opcion.class);
        menu = query.getResultList();
        return menu;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Opcion> obtenerOpciones(int perfilId) {
        Query query = em.createQuery("select distinct o "
                + "from Opcion o, "
                + "in (o.permisos) p, "
                + "in (p.perfil) f "
                + "where "
                + "f.perfilId = :perfilId "
                + "and o.estado = :estado "
                //+ "and o.visible = :visible "
                + "and o.nivel = 1"
                + " order by o.nivel, o.orden");

        query.setParameter("perfilId", perfilId);
        query.setParameter("estado", EstadoEnum.ACTIVO.getEstado());
        //query.setParameter("visible", true);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Opcion> obtenerOpciones(List<String> perfil) {
        Query query = em.createQuery("select distinct o "
                + "from Opcion o, "
                + "in (o.permisos) p, "
                + "in (p.perfil) f "
                + "where "
                + "f.nombre in (:nombre) "
                + "and o.estado = :estado "
                + "and o.nivel = 1"
                + " order by o.nivel, o.orden");
        query.setParameter("nombre", perfil);
        query.setParameter("estado", EstadoEnum.ACTIVO.getEstado());
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Opcion> obtenerOpcionesPerfilId(List<String> perfil) {
        List<Integer> perfiles = perfil.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        Query query = em.createQuery("select distinct o "
                + "from Opcion o, "
                + "in (o.permisos) p, "
                + "in (p.perfil) f "
                + "where "
                + "f.perfilId in (:perfilId) "
                + "and o.estado = :estado "
                + "and o.nivel = 1"
                + " order by o.nivel, o.orden");
        query.setParameter("perfilId", perfiles);
        query.setParameter("estado", EstadoEnum.ACTIVO.getEstado());
        return query.getResultList();
    }
}
