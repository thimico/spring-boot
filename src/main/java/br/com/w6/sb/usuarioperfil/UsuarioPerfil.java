package br.com.w6.sb.usuarioperfil;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.w6.sb.utils.AbstractEntity;


@Entity
@Table(name="sc_usuario_perfil", schema="segcartorio")
public class UsuarioPerfil extends AbstractEntity<Long> {

	private static final long serialVersionUID = 201602010251L;

}