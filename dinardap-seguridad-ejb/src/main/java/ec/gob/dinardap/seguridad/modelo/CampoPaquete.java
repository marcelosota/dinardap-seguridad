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
 * The persistent class for the campo_paquete database table.
 * 
 */
@Entity
@Table(name="campo_paquete", schema="ec_dinardap_seguridad")
@NamedQuery(name="CampoPaquete.findAll", query="SELECT c FROM CampoPaquete c")
public class CampoPaquete implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CAMPO_PAQUETE_CAMPOPAQUETEID_GENERATOR", sequenceName="campo_paquete_campo_paquete_id_seq", schema="ec_dinardap_seguridad", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAMPO_PAQUETE_CAMPOPAQUETEID_GENERATOR")
	@Column(name="campo_paquete_id")
	private Integer campoPaqueteId;

	@Column(name="estado")
	private Short estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	//bi-directional many-to-one association to Campo
	@ManyToOne
	@JoinColumn(name="campo_id")
	private Campo campo;

	//bi-directional many-to-one association to Paquete
	@ManyToOne
	@JoinColumn(name="paquete_id")
	private Paquete paquete;

	public CampoPaquete() {
	}

	public Integer getCampoPaqueteId() {
		return this.campoPaqueteId;
	}

	public void setCampoPaqueteId(Integer campoPaqueteId) {
		this.campoPaqueteId = campoPaqueteId;
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

	public Campo getCampo() {
		return this.campo;
	}

	public void setCampo(Campo campo) {
		this.campo = campo;
	}

	public Paquete getPaquete() {
		return this.paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

}