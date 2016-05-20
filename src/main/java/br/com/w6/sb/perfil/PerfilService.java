package br.com.w6.sb.perfil;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.w6.sb.utils.AbstractService;
import br.com.w6.sb.utils.ServicePath;

@RestController
@RequestMapping(path = ServicePath.PERFIL_PATH)
public class PerfilService extends AbstractService<Perfil, Long> {


	

}
