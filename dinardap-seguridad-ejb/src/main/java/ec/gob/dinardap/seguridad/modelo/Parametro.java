package ec.gob.dinardap.seguridad.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the parametro database table.
 * 
 */
@Entity
@Table(name="parametro", schema="ec_dinardap_seguridad")
@NamedQuery(name="Parametro.findAll", query="SELECT p FROM Parametro p")
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name="PARAMETRO_PARAMETROID_GENERATOR", sequenceName="parametro_parametro_id_seq", schema="ec_dinardap_seguridad", allocationSize = 1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARAMETRO_PARAMETROID_GENERATOR")
	//@Column(name="parametro_id")
	//private Integer parametroId;

	@Column(name="nombre", length = 64)
	private String nombre;
	
	@Column(name="estado")
	private Short estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	@Column(name="usuario_modifica_is")
	private String usuarioModificaIs;

	@Column(name="usuario_registra_is")
	private String usuarioRegistraIs;

	@Column(name="valor", length = 256)
	private String valor;

	public Parametro() {
	}

	/*public Integer getParametroId() {
		return this.parametroId;
	}

	public void setParametroId(Integer parametroId) {
		this.parametroId = parametroId;
	}*/

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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuarioModificaIs() {
		return this.usuarioModificaIs;
	}

	public void setUsuarioModificaIs(String usuarioModificaIs) {
		this.usuarioModificaIs = usuarioModificaIs;
	}

	public String getUsuarioRegistraIs() {
		return this.usuarioRegistraIs;
	}

	public void setUsuarioRegistraIs(String usuarioRegistraIs) {
		this.usuarioRegistraIs = usuarioRegistraIs;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}