package ec.gob.dinardap.seguridad.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the fuente database table.
 * 
 */
@Entity
@Table(name="fuente", schema="ec_dinardap_seguridad")
@NamedQuery(name="Fuente.findAll", query="SELECT f FROM Fuente f")
public class Fuente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FUENTE_FUENTEID_GENERATOR", sequenceName="fuente_fuente_id_seq", schema="ec_dinardap_seguridad", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FUENTE_FUENTEID_GENERATOR")
	@Column(name="fuente_id")
	private Integer fuenteId;

	@Column(name="descripcion", length = 256)
	private String descripcion;

	@Column(name="estado")
	private Short estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	//bi-directional many-to-one association to Campo
	@OneToMany(mappedBy="fuente")
	private List<Campo> campos;

	//bi-directional many-to-one association to Institucion
	@ManyToOne
	@JoinColumn(name="institucion_id")
	private Institucion institucion;

	public Fuente() {
	}

	public Integer getFuenteId() {
		return this.fuenteId;
	}

	public void setFuenteId(Integer fuenteId) {
		this.fuenteId = fuenteId;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public List<Campo> getCampos() {
		return this.campos;
	}

	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}

	public Campo addCampo(Campo campo) {
		getCampos().add(campo);
		campo.setFuente(this);

		return campo;
	}

	public Campo removeCampo(Campo campo) {
		getCampos().remove(campo);
		campo.setFuente(null);

		return campo;
	}

	public Institucion getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}

}