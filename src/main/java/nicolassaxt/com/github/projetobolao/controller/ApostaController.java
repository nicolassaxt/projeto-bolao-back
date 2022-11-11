package nicolassaxt.com.github.projetobolao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nicolassaxt.com.github.projetobolao.controller.dto.ApostaDTO;
import nicolassaxt.com.github.projetobolao.controller.dto.PartidaCreateDTO;
import nicolassaxt.com.github.projetobolao.controller.mapper.ApostaMapper;
import nicolassaxt.com.github.projetobolao.model.Aposta;
import nicolassaxt.com.github.projetobolao.model.Partida;
import nicolassaxt.com.github.projetobolao.repository.ApostaRepository;
import nicolassaxt.com.github.projetobolao.repository.PartidaRepository;
import nicolassaxt.com.github.projetobolao.repository.UsuarioRepository;
import nicolassaxt.com.github.projetobolao.service.ApostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aposta")
@Api(tags = "Aposta Controller")
public class ApostaController {
    private final ApostaService apostaService;
    private final ApostaMapper apostaMapper;

    public ApostaController(ApostaService apostaService, ApostaMapper apostaMapper) {
        this.apostaService = apostaService;
        this.apostaMapper = apostaMapper;
    }

    @Autowired
    private ApostaRepository apostaRepository;

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    @ApiOperation("Find all Apostas")
    public ResponseEntity<List<ApostaDTO>> findAll(){
        List<Aposta> partidaList = apostaService.findAll();
        List<ApostaDTO> result = apostaMapper.toApostaDTOList(partidaList);
        return  ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApostaDTO> findById(@PathVariable Long id){
        Aposta aposta = apostaService.findById(id);
        ApostaDTO result = apostaMapper.toApostaDTO(aposta);
        return  ResponseEntity.ok(result); //retornando 200
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        apostaService.delete(id);
        return  ResponseEntity.noContent().build(); //retornando 204
    }

//    @PostMapping
//    public ResponseEntity<ApostaDTO> create(@RequestBody ApostaDTO dto){
//        Aposta apostaCreate = apostaMapper.toAposta(dto);
//        Aposta aposta = apostaService.create(apostaCreate);
//        ApostaDTO result = apostaMapper.toApostaDTO(aposta);
//        return  ResponseEntity.status(HttpStatus.CREATED).body(result); //retornando 201
//    }

    @PostMapping
    public Aposta save(@RequestBody ApostaDTO dto){
        Aposta aposta = apostaService.criarAposta(dto, partidaRepository, usuarioRepository);
        return apostaRepository.save(aposta);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApostaDTO> update(@PathVariable Long id ,@RequestBody ApostaDTO dto){
        Aposta apostaCreate = apostaMapper.toAposta(dto);
        Aposta aposta = apostaService.update(id ,apostaCreate);
        ApostaDTO result = apostaMapper.toApostaDTO(aposta);
        return  ResponseEntity.status(HttpStatus.OK).body(result); //retornando 200
    }
}
