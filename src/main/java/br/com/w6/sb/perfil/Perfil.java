package br.com.w6.sb.perfil;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import br.com.w6.sb.sistema.Sistema;
import br.com.w6.sb.usuario.Usuario;
import br.com.w6.sb.utils.AbstractEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="sc_perfil")
@NamedQuery(name="Perfil.findAll", query="SELECT s FROM Perfil s")
@AttributeOverride(name = "id", column = @Column(name = "id_perfil"))
public class Perfil extends AbstractEntity<Long> {
	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name = "SC_PERFIL_ID_GENERATOR", sequenceName = "seq_id_perfil", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SC_PERFIL_ID_GENERATOR")
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}
	
	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}
	
	@Column(name="ds_perfil", nullable=false, length=50)
	private String dsPerfil;

	@Column(name="nm_perfil", nullable=false, length=20)
	private String nmPerfil;

	@ManyToOne
	@JoinColumn(name="fk_id_sistema", nullable=false)
	private Sistema sistema;

	@JsonIgnore
	@ManyToMany(mappedBy="perfis")
	private List<Usuario> usuarios;
}
