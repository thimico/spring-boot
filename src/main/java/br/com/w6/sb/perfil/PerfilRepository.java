package br.com.w6.sb.perfil;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "perfil", path = "perfil")
public interface PerfilRepository  extends JpaRepository<Perfil, Long> {

	public Perfil findByDsPerfil(String desc);

	public List<Perfil> findByDsPerfilOrNmPerfil(String dsPerfil, String nmPerfil);

}
