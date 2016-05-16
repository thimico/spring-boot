package br.com.w6.sb.perfil;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PerfilRepository  extends JpaRepository<Perfil, Long> {

	public Perfil findByDsPerfil(String desc);

	public List<Perfil> findByDsPerfilOrNmPerfil(String dsPerfil, String nmPerfil);

}
