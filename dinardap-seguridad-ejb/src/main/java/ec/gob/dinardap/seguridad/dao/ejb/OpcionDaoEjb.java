package ec.gob.dinardap.seguridad.dao.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.OpcionDao;
import ec.gob.dinardap.seguridad.modelo.Opcion;
import ec.gob.dinardap.util.constante.EstadoEnum;

@Stateless(name="OpcionDao")
public class OpcionDaoEjb extends GenericDaoEjb<Opcion, Integer> implements OpcionDao {

	public OpcionDaoEjb() {
		super(Opcion.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Opcion> obtenerOpcionesPorPerfil1(String misPerfiles) {
		List<Opcion> menu = new ArrayList<Opcion>();
		StringBuilder sql = new StringBuilder("with recursive menu as( ");
		sql.append("select o.opcion_id, o.padre_id, o.nombre, o.url, o.nivel, o.orden, o.visible, o.estado ");
		sql.append("from ec_dinardap_seguridad.opcion o "); 
		sql.append("inner join ec_dinardap_seguridad.permiso r on o.opcion_id = r.opcion_id "); 
		sql.append("where r.perfil_id in( ").append(misPerfiles).append(") or (o.padre_id is null and ");
		sql.append("r.perfil_id in( ").append(misPerfiles).append(")) ");
		//sql.append("where r.perfil_id = ").append(perfilId).append(" or o.padre_id is null ");
		sql.append("union ");
		sql.append("select p.opcion_id, p.padre_id, p.nombre, p.url, p.nivel, p.orden, p.visible, p.estado "); 
		sql.append("from ec_dinardap_seguridad.opcion p "); 
		sql.append("inner join ec_dinardap_seguridad.permiso r on p.opcion_id = r.opcion_id "); 
		sql.append("inner join menu m on m.opcion_id = p.padre_id)");
		sql.append("select opcion_id, padre_id, nombre, url, nivel, orden, visible, estado "); 
		sql.append("from menu "); 
		sql.append("where estado = ").append(EstadoEnum.ACTIVO.getEstado()).append(" and visible = true ");
		
		Query query = em.createNativeQuery(sql.toString());
		List<Object[]> lista = query.getResultList();
		for (Object[] item : lista) {
			Opcion opcion = new Opcion();
			opcion.setOpcionId(Integer.parseInt(item[0].toString()));
			if(item[1] != null) {
				Opcion opcionP = new Opcion();
				opcionP.setOpcionId(Integer.parseInt(item[1].toString()));
				opcion.setOpcion(opcionP);
			}else
				opcion.setOpcion(null);
			opcion.setNombre(item[2].toString());
			if(item[3] != null)
				opcion.setUrl(item[3].toString());
			else
				opcion.setUrl(null);
			opcion.setNivel(Short.parseShort(item[4].toString()));
			opcion.setOrden(Short.parseShort(item[5].toString()));
			opcion.setVisible(Boolean.parseBoolean(item[6].toString()));
			opcion.setEstado(Short.parseShort(item[7].toString()));
			menu.add(opcion);
		}
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
	public List<Opcion> obtenerOpcionesPerfilId(String perfil) {
		Query query = em.createQuery("select distinct o "
				+ "from Opcion o, "
				+ "in (o.permisos) p, "
				+ "in (p.perfil) f "
				+ "where "
				+ "f.perfilId in (:perfilId) "
				+ "and o.estado = :estado "
				+ "and o.nivel = 1"
				+ " order by o.nivel, o.orden");
		
		query.setParameter("perfilId", perfil);
		query.setParameter("estado", EstadoEnum.ACTIVO.getEstado());
		
		return query.getResultList();
	}

}
