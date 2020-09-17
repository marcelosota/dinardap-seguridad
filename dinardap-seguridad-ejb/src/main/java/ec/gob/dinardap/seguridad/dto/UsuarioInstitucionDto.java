package ec.gob.dinardap.seguridad.dto;

import java.util.Date;

public class UsuarioInstitucionDto {

    private Integer asignacionInstitucionId;
    private String ruc;
    private String nombre;
    private String siglas;
    private String tipoInstitucion;
    private Date fechaCreacion;
    private Boolean estado;

    public Integer getAsignacionInstitucionId() {
        return asignacionInstitucionId;
    }

    public void setAsignacionInstitucionId(Integer asignacionInstitucionId) {
        this.asignacionInstitucionId = asignacionInstitucionId;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getTipoInstitucion() {
        return tipoInstitucion;
    }

    public void setTipoInstitucion(String tipoInstitucion) {
        this.tipoInstitucion = tipoInstitucion;
    }

}
