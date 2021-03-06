package br.com.w6.sb.sistema;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="sc_sistema")
@AttributeOverride(name = "id", column = @Column(name = "id_sistema"))
public class Sistema extends AbstractEntity<Long> { 

	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name = "SC_SISTEMA_ID_GENERATOR", sequenceName = "seq_id_sistema", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SC_SISTEMA_ID_GENERATOR")
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
 
	@JsonIgnore
	//bi-directional many-to-one association to Perfil
	@OneToMany(mappedBy="sistema",fetch= FetchType.EAGER)
	private List<Perfil> perfis;

}
