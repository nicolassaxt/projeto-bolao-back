package nicolassaxt.com.github.projetobolao.controller.mapper;

import nicolassaxt.com.github.projetobolao.controller.dto.TimeDTO;
import nicolassaxt.com.github.projetobolao.model.Time;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TimeMapper {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public TimeDTO toTimeDTO(Time time){
        return MODEL_MAPPER.map(time, TimeDTO.class);
    }
    public List<TimeDTO> toTimeDTOList(List<Time> timeList) {
        return timeList.stream().map(this::toTimeDTO).collect(Collectors.toList());
    }

    public Time toTime(TimeDTO dto){
        return MODEL_MAPPER.map(dto, Time.class);
    }

//    public Time toTimeCreate(TimeDTO dto) {
//        return MODEL_MAPPER.map(dto, Time.class);
//    }
}
