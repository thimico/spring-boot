package br.com.w6.sb.usuaio;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.w6.sb.utils.AbstractService;
import br.com.w6.sb.utils.ServicePath;

@RestController
@RequestMapping(path = ServicePath.USER_PATH)
public class UsuarioService extends AbstractService<Usuario, Long> {
	


}
