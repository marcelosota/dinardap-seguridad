package ec.gob.dinardap.seguridad.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the asignacion database table.
 * 
 */
@Entity
@Table(name="asignacion", schema="ec_dinardap_seguridad")
@NamedQuery(name="Asignacion.findAll", query="SELECT a FROM Asignacion a")
public class Asignacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ASIGNACION_ASIGNACIONID_GENERATOR", sequenceName="asignacion_asignacion_id_seq", schema="ec_dinardap_seguridad", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ASIGNACION_ASIGNACIONID_GENERATOR")
	@Column(name="asignacion_id")
	private Integer asignacionId;

	@Column(name="estado")
	private Short estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	@Column(name="perfil_is")
	private String perfilIs;

	@Column(name="usuario_is")
	private String usuarioIs;

	//bi-directional many-to-one association to Paquete
	@ManyToOne
	@JoinColumn(name="paquete_id")
	private Paquete paquete;

	public Asignacion() {
	}

	public Integer getAsignacionId() {
		return this.asignacionId;
	}

	public void setAsignacionId(Integer asignacionId) {
		this.asignacionId = asignacionId;
	}

	public Short getEstado() {
		return this.estado;
	}

	public void setEstado(Short estado) {
		this.estado = estado;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getPerfilIs() {
		return this.perfilIs;
	}

	public void setPerfilIs(String perfilIs) {
		this.perfilIs = perfilIs;
	}

	public String getUsuarioIs() {
		return this.usuarioIs;
	}

	public void setUsuarioIs(String usuarioIs) {
		this.usuarioIs = usuarioIs;
	}

	public Paquete getPaquete() {
		return this.paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

}