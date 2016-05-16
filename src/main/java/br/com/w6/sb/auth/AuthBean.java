package br.com.w6.sb.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import br.com.w6.sb.utils.AbstractBean;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class AuthBean extends AbstractBean {

	private static final long serialVersionUID = 201504161025L;

	private String usuario;

	private String senha;

	
}
