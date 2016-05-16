package br.com.w6.sb.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.w6.sb.usuaio.Usuario;
import br.com.w6.sb.usuaio.UsuarioRepository;
import br.com.w6.sb.utils.ServiceMap;
import br.com.w6.sb.utils.ServicePath;

@RestController
@RequestMapping(ServicePath.AUTH_PATH)
public class AuthService implements ServiceMap {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping(method = { RequestMethod.POST })
	public Usuario auth(@RequestBody AuthBean auth) {
		Usuario temp = this.usuarioRepository.findByNmLogin(auth.getUsuario());
		return temp;
	}
}
