package ec.gob.dinardap.seguridad.dto;

public class ValidacionDto {

	public Integer usuarioId;
	public String institucionId;
	public String perfil;
	
	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getInstitucionId() {
		return institucionId;
	}
	public void setInstitucionId(String institucionId) {
		this.institucionId = institucionId;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
}
