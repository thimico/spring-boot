package br.com.w6.sb.perfil;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import br.com.w6.sb.sistema.Sistema;
import br.com.w6.sb.usuaio.Usuario;
import br.com.w6.sb.utils.AbstractEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="sc_perfil", schema="segcartorio")
@NamedQuery(name="Perfil.findAll", query="SELECT s FROM Perfil s")
public class Perfil extends AbstractEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Column(name="ds_perfil", nullable=false, length=50)
	private String dsPerfil;

	@Column(name="nm_perfil", nullable=false, length=20)
	private String nmPerfil;
	   
	@JsonBackReference
	@ManyToMany(mappedBy = "perfis", fetch= FetchType.EAGER)
	private List<Usuario> usuarios;
	 

	@JsonBackReference
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="fk_id_sistema", nullable=false)
	private Sistema sistema;

	
}
