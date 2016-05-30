package br.com.w6.sb.usuarioperfil;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

import br.com.w6.sb.utils.AbstractKey;

@Embeddable
public class UsuarioPerfilKey extends AbstractKey {

	private static final long serialVersionUID = 201602010536L;

	@Column(name = "fk_id_perfil", length = 11, nullable = false)
	private Long perfilId;

	@Column(name = "fk_id_usuario", length = 11, nullable = false)
	private Long userId;

	public UsuarioPerfilKey() {
	}

	public UsuarioPerfilKey(Long perfilId, Long userId) {
		super();
		this.perfilId = perfilId;
		this.userId = userId;
	}

	public Long getPermissionId() {
		return this.perfilId;
	}

	public void setPermissionId(Long perfilId) {
		this.perfilId = perfilId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((this.perfilId == null) ? 0 : this.perfilId.hashCode());
		result = prime * result + ((this.userId == null) ? 0 : this.userId.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!super.equals(obj)) {
			return false;
		}

		if (this.getClass() != obj.getClass()) {
			return false;
		}

		UsuarioPerfilKey other = (UsuarioPerfilKey) obj;

		if (this.perfilId == null) {
			if (other.perfilId != null) {
				return false;
			}
		} else if (!this.perfilId.equals(other.perfilId)) {
			return false;
		}

		if (this.userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!this.userId.equals(other.userId)) {
			return false;
		}

		return true;
	}

}
