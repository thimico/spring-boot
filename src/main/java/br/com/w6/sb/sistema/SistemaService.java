package br.com.w6.sb.sistema;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.w6.sb.utils.AbstractService;
import br.com.w6.sb.utils.ServicePath;

@RestController
@RequestMapping(path = ServicePath.SISTEMA_PATH)
public class SistemaService extends AbstractService<Sistema, Long> {




}
