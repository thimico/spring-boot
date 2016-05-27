package br.com.w6.sb.usuaio;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.w6.sb.perfil.Perfil;
import br.com.w6.sb.utils.AbstractEntity;
import br.com.w6.sb.utils.enums.EStatus;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sc_usuario", schema = "segcartorio")
public class Usuario extends AbstractEntity<Long>{

	private static final long serialVersionUID = 1L;


	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento", nullable = false)
	private Date dtNascimento;

	@Past
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_ult_acesso")
	private Date dtUltAcesso;

	@Column(name = "bt_foto")
	private byte[] nmFoto;

	@Column(name = "nm_login", nullable = false, length = 20)
	private String nmLogin;

	@Column(name = "nm_senha", nullable = false, length = 50)
	private String nmSenha;

	@Column(name = "nm_usuario", nullable = false, length = 50)
	private String nmUsuario;

	@Column(name = "nm_funcao", nullable = false, length = 100)
	private String nmFuncao;
	
	@Column(name = "tx_cpf", nullable = false, length = 11)
	private String txCpf;

	//	@Email TODO
	@Column(name = "tx_email", nullable = false, length = 50)
	private String txEmail;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "st_usuario")
	//	private String stUsuario;
	private EStatus stUsuario;
	
	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable(name = "segcartorio.sc_usuario_perfil", joinColumns = @JoinColumn(name = "fk_id_usuario"), inverseJoinColumns = @JoinColumn(name = "fk_id_perfil") )
	private List<Perfil> perfis;


	
}
