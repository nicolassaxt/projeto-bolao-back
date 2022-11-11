package nicolassaxt.com.github.projetobolao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nicolassaxt.com.github.projetobolao.controller.dto.PartidaCreateDTO;
import nicolassaxt.com.github.projetobolao.controller.dto.PartidaDTO;
import nicolassaxt.com.github.projetobolao.controller.mapper.PartidaMapper;
import nicolassaxt.com.github.projetobolao.model.Partida;
import nicolassaxt.com.github.projetobolao.model.Time;
import nicolassaxt.com.github.projetobolao.repository.PartidaRepository;
import nicolassaxt.com.github.projetobolao.repository.TimeRepository;
import nicolassaxt.com.github.projetobolao.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partida")
@Api(tags = "Partida Controller")
public class PartidaController {

    private final PartidaService partidaService;
    private final PartidaMapper partidaMapper;

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private TimeRepository timeRepository;

    public PartidaController(PartidaService partidaService, PartidaMapper partidaMapper) {
        this.partidaService = partidaService;
        this.partidaMapper = partidaMapper;
    }

    @GetMapping
    @ApiOperation("Find all Partidas")
    public ResponseEntity<List<PartidaDTO>> findAll(){
        List<Partida> partidaList = partidaService.findAll();
        List<PartidaDTO> result = partidaMapper.toPartidaDTOList(partidaList);
        return  ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidaDTO> findById(@PathVariable Long id){
        Partida partida = partidaService.findById(id);
        PartidaDTO result = partidaMapper.toPartidaDTO(partida);
        return  ResponseEntity.ok(result); //retornando 200
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        partidaService.delete(id);
        return  ResponseEntity.noContent().build(); //retornando 204
    }

//    @PostMapping
//    public ResponseEntity<PartidaDTO> create(@RequestBody PartidaCreateDTO dto){
//        Partida partidaCreate = partidaMapper.toPartidaCreate(dto);
//        Partida partida = partidaService.create(partidaCreate);
//        PartidaDTO result = partidaMapper.toPartidaDTO(partida);
//        return  ResponseEntity.status(HttpStatus.CREATED).body(result); //retornando 201
//    }

    @PostMapping
    public Partida save(@RequestBody PartidaCreateDTO dto){
        Partida partida = partidaService.criarPartida(dto, timeRepository);
        return partidaRepository.save(partida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartidaDTO> update(@PathVariable Long id ,@RequestBody PartidaCreateDTO dto){
        Partida partidaCreate = partidaMapper.toPartidaCreate(dto);
        Partida partida = partidaService.update(id ,partidaCreate);
        PartidaDTO result = partidaMapper.toPartidaDTO(partida);
        return  ResponseEntity.status(HttpStatus.OK).body(result); //retornando 200
    }
}
