package ec.gob.dinardap.seguridad.constante;

public enum TipoPerfilEnum {

	INTERNO((short) 1), EXTERNO((short) 2);
	
	private short tipoPerfil;

	TipoPerfilEnum(short tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

	public short getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(short tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}
	
}
