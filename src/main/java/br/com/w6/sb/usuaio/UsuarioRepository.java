package br.com.w6.sb.usuaio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByTxEmail(String email);
	
	public Usuario findByNmLogin(String login);

	public List<Usuario> findByTxEmailOrNmUsuario(String email, String name);

}
