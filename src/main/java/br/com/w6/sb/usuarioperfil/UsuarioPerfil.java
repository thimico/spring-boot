package br.com.w6.sb.usuarioperfil;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.w6.sb.utils.AbstractEntity;


@Entity
@Table(name="sc_usuario_perfil")
public class UsuarioPerfil extends AbstractEntity<UsuarioPerfilKey> {

	private static final long serialVersionUID = 201602010251L;

}