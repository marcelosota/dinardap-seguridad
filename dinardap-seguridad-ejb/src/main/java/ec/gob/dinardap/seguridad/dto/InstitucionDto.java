package ec.gob.dinardap.seguridad.dto;

import java.util.Date;

public class InstitucionDto {

	private Integer institucionId;
	private Integer tipoInstitucionId;
	private String ruc;
	private String nombre;
	private String siglas;
	private Integer codigoIs;
	private Integer provinciaId;
	private Integer cantonId;
	private Integer adscrita;
	private Date fechaRegistro;
	private Short estado;
	
	public Integer getInstitucionId() {
		return institucionId;
	}
	public void setInstitucionId(Integer institucionId) {
		this.institucionId = institucionId;
	}
	public Integer getTipoInstitucionId() {
		return tipoInstitucionId;
	}
	public void setTipoInstitucionId(Integer tipoInstitucionId) {
		this.tipoInstitucionId = tipoInstitucionId;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSiglas() {
		return siglas;
	}
	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}
	public Integer getCodigoIs() {
		return codigoIs;
	}
	public void setCodigoIs(Integer codigoIs) {
		this.codigoIs = codigoIs;
	}
	public Integer getProvinciaId() {
		return provinciaId;
	}
	public void setProvinciaId(Integer provinciaId) {
		this.provinciaId = provinciaId;
	}
	public Integer getCantonId() {
		return cantonId;
	}
	public void setCantonId(Integer cantonId) {
		this.cantonId = cantonId;
	}
	public Integer getAdscrita() {
		return adscrita;
	}
	public void setAdscrita(Integer adscrita) {
		this.adscrita = adscrita;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Short getEstado() {
		return estado;
	}
	public void setEstado(Short estado) {
		this.estado = estado;
	}
	
}