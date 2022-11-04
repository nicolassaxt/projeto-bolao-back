package nicolassaxt.com.github.projetobolao.controller;

import nicolassaxt.com.github.projetobolao.controller.dto.UsuarioDTO;
import nicolassaxt.com.github.projetobolao.controller.mapper.UsuarioMapper;
import nicolassaxt.com.github.projetobolao.model.Usuario;
import nicolassaxt.com.github.projetobolao.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    public UsuarioController(UsuarioService usuarioService, UsuarioMapper usuarioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
    }

    @GetMapping
    public List<UsuarioDTO> findAll(){
        List<Usuario> usuarioList = usuarioService.findAll();
        List<UsuarioDTO> result = usuarioMapper.toUsuarioDTOList(usuarioList);
        return  result;
    }
}
