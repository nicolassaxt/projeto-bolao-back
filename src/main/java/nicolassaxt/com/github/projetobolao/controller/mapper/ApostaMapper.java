package nicolassaxt.com.github.projetobolao.controller.mapper;

import nicolassaxt.com.github.projetobolao.controller.dto.ApostaDTO;
import nicolassaxt.com.github.projetobolao.model.Aposta;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApostaMapper {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ApostaDTO toApostaDTO(Aposta aposta){
        return MODEL_MAPPER.map(aposta, ApostaDTO.class);
    }

    public List<ApostaDTO> toApostaDTOList(List<Aposta> apostaList) {
        return apostaList.stream().map(this::toApostaDTO).collect(Collectors.toList());
    }

    public Aposta toAposta(ApostaDTO dto){
        return MODEL_MAPPER.map(dto, Aposta.class);
    }

//    public Aposta toApostaCreate(ApostaDTO dto) {
//        return MODEL_MAPPER.map(dto, Aposta.class);
//    }
}
