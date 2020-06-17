package ec.gob.dinardap.seguridad.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.gob.dinardap.persistence.servicio.GenericService;
import ec.gob.dinardap.seguridad.dto.InstitucionDto;
import ec.gob.dinardap.seguridad.modelo.Institucion;

@Local
public interface InstitucionServicio extends GenericService<Institucion, Integer> {

	public List<Institucion> obtenerInstitucionesTipoCantonEstado(Integer tipoInstitucionId, Integer cantonId, Short estado);
	public Institucion buscarInsttucionPorRuc(String ruc);
	public List<Institucion> buscarInstitucionPorTipo(Integer tipoInstitucionId);
	public boolean guardarInstitucion(InstitucionDto institucionDto);
	public void actualizarInstitucion(InstitucionDto institucionDto);
}
