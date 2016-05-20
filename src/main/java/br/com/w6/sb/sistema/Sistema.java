package br.com.w6.sb.sistema;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import br.com.w6.sb.perfil.Perfil;
import br.com.w6.sb.utils.AbstractEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="sc_sistema", schema="segcartorio")
public class Sistema extends AbstractEntity<Long> { 

	private static final long serialVersionUID = 1L;


	@Column(name="ds_sistema", nullable=false, length=100)
	private String dsSistema;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_ult_validacao", nullable=false)
	private Date dtUltValidacao;

	@Column(name="nm_sistema", nullable=false, length=50)
	private String nmSistema;

	@Column(name="sg_sistema", nullable=false, length=10)
	private String sgSistema;

	@Column(name="tx_chave_validacao", nullable=false, length=100)
	private String txChaveValidacao;

	@Column(name="tx_url", nullable=false, length=256)
	private String txUrl;

	@JsonManagedReference
	//bi-directional many-to-one association to Perfil
	@OneToMany(mappedBy="sistema",fetch= FetchType.EAGER)
	private List<Perfil> perfis;

}
