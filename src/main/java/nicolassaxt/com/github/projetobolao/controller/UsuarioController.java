package nicolassaxt.com.github.projetobolao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nicolassaxt.com.github.projetobolao.controller.dto.UsuarioCreateDTO;
import nicolassaxt.com.github.projetobolao.controller.dto.UsuarioDTO;
import nicolassaxt.com.github.projetobolao.controller.mapper.UsuarioMapper;
import nicolassaxt.com.github.projetobolao.model.Usuario;
import nicolassaxt.com.github.projetobolao.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "Usuario Controller")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    public UsuarioController(UsuarioService usuarioService, UsuarioMapper usuarioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
    }

    @GetMapping
    @ApiOperation("Find all usuarios")
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        List<Usuario> usuarioList = usuarioService.findAll();
        List<UsuarioDTO> result = usuarioMapper.toUsuarioDTOList(usuarioList);
        return  ResponseEntity.ok(result);
    }

    @GetMapping("/managers") //rota teste admin
    public String managers() {
        return "Authorized manager";
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable String id){
        Usuario usuario = usuarioService.findById(id);
        UsuarioDTO result = usuarioMapper.toUsuarioDTO(usuario);
        return  ResponseEntity.ok(result); //retornando 200
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        usuarioService.delete(id);
        return  ResponseEntity.noContent().build(); //retornando 204
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioCreateDTO dto){
        Usuario usuarioCreate = usuarioMapper.toUsuarioCreate(dto);
        Usuario usuario = usuarioService.create(usuarioCreate);
        UsuarioDTO result = usuarioMapper.toUsuarioDTO(usuario);
        return  ResponseEntity.status(HttpStatus.CREATED).body(result); //retornando 201
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable String id ,@RequestBody UsuarioCreateDTO dto){
        Usuario usuarioCreate = usuarioMapper.toUsuarioCreate(dto);
        Usuario usuario = usuarioService.update(id ,usuarioCreate);
        UsuarioDTO result = usuarioMapper.toUsuarioDTO(usuario);
        return  ResponseEntity.status(HttpStatus.OK).body(result); //retornando 200
    }
}
