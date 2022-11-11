package nicolassaxt.com.github.projetobolao.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nicolassaxt.com.github.projetobolao.controller.dto.TimeDTO;
import nicolassaxt.com.github.projetobolao.controller.mapper.TimeMapper;
import nicolassaxt.com.github.projetobolao.model.Time;
import nicolassaxt.com.github.projetobolao.service.TimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time")
@Api(tags = "time Controller")
public class TimeController {

    private final TimeService timeService;
    private final TimeMapper timeMapper;

    public TimeController(TimeService timeService, TimeMapper timeMapper) {
        this.timeService = timeService;
        this.timeMapper = timeMapper;
    }

    @GetMapping
    @ApiOperation("Find all times")
    public ResponseEntity<List<TimeDTO>> findAll(){
        List<Time> usuarioList = timeService.findAll();
        List<TimeDTO> result = timeMapper.toTimeDTOList(usuarioList);
        return  ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeDTO> findById(@PathVariable Long id){
        Time time = timeService.findById(id);
        TimeDTO result = timeMapper.toTimeDTO(time);
        return  ResponseEntity.ok(result); //retornando 200
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        timeService.delete(id);
        return  ResponseEntity.noContent().build(); //retornando 204
    }

    @PostMapping
    public ResponseEntity<TimeDTO> create(@RequestBody TimeDTO dto){
        Time timeCreate = timeMapper.toTime(dto);
        Time time = timeService.create(timeCreate);
        TimeDTO result = timeMapper.toTimeDTO(time);
        return  ResponseEntity.status(HttpStatus.CREATED).body(result); //retornando 201
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimeDTO> update(@PathVariable Long id ,@RequestBody TimeDTO dto){
        Time timeCreate = timeMapper.toTime(dto);
        Time time = timeService.update(id ,timeCreate);
        TimeDTO result = timeMapper.toTimeDTO(time);
        return  ResponseEntity.status(HttpStatus.OK).body(result); //retornando 200
    }
}
