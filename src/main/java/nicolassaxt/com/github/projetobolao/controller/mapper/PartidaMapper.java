package nicolassaxt.com.github.projetobolao.controller.mapper;

import nicolassaxt.com.github.projetobolao.controller.dto.PartidaCreateDTO;
import nicolassaxt.com.github.projetobolao.controller.dto.PartidaDTO;
import nicolassaxt.com.github.projetobolao.model.Partida;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PartidaMapper {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public PartidaDTO toPartidaDTO(Partida partida){
        return MODEL_MAPPER.map(partida, PartidaDTO.class);
    }
    public List<PartidaDTO> toPartidaDTOList(List<Partida> partidaList) {
        return partidaList.stream().map(this::toPartidaDTO).collect(Collectors.toList());
    }

    public Partida toPartida(PartidaDTO dto){
        return MODEL_MAPPER.map(dto, Partida.class);
    }

    public Partida toPartidaCreate(PartidaCreateDTO dto) {
        return MODEL_MAPPER.map(dto, Partida.class);
    }
}
