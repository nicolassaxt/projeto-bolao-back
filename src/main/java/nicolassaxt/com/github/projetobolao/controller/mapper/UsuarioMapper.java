package nicolassaxt.com.github.projetobolao.controller.mapper;

import nicolassaxt.com.github.projetobolao.controller.dto.UsuarioCreateDTO;
import nicolassaxt.com.github.projetobolao.controller.dto.UsuarioDTO;
import nicolassaxt.com.github.projetobolao.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public UsuarioDTO toUsuarioDTO(Usuario usuario){
        return MODEL_MAPPER.map(usuario, UsuarioDTO.class);
    }
    public List<UsuarioDTO> toUsuarioDTOList(List<Usuario> usuarioList) {
        return usuarioList.stream().map(this::toUsuarioDTO).collect(Collectors.toList());
    }

    public Usuario toUsuario(UsuarioDTO dto){
        return MODEL_MAPPER.map(dto, Usuario.class);
    }

    public Usuario toUsuarioCreate(UsuarioCreateDTO dto) {
        return MODEL_MAPPER.map(dto, Usuario.class);
    }
}
