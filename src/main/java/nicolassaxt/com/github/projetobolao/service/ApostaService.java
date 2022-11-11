package nicolassaxt.com.github.projetobolao.service;

import nicolassaxt.com.github.projetobolao.controller.dto.ApostaDTO;
import nicolassaxt.com.github.projetobolao.controller.dto.PartidaCreateDTO;
import nicolassaxt.com.github.projetobolao.exception.ApostaNotFoundException;
import nicolassaxt.com.github.projetobolao.model.Aposta;
import nicolassaxt.com.github.projetobolao.model.Partida;
import nicolassaxt.com.github.projetobolao.model.StatusAposta;
import nicolassaxt.com.github.projetobolao.model.Usuario;
import nicolassaxt.com.github.projetobolao.repository.ApostaRepository;
import nicolassaxt.com.github.projetobolao.repository.PartidaRepository;
import nicolassaxt.com.github.projetobolao.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ApostaService {
    private final ApostaRepository apostaRepository;


    public ApostaService(ApostaRepository apostaRepository) { //construtor para injeção de dependencia
        this.apostaRepository = apostaRepository;
    }


    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Aposta> findAll(){
        return apostaRepository.findAll();
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    } //Gerando ID randomico

    @Transactional(readOnly = true)
    public Aposta findById(Long id) {
        return apostaRepository.findById(id).orElseThrow(() ->
                new ApostaNotFoundException(id)); //criar notfound para os outros atributos

    }
    @Transactional
    public Aposta create(Aposta apostaCreate) {
        apostaCreate.setStatus(StatusAposta.ND);
        //apostaCreate.setPartidaId(partida); //inserindo partida
       // apostaCreate.setUsuarioId(usuario); //inserindo usuario
        apostaRepository.save(apostaCreate);
        return apostaCreate;
    }
    @Transactional
    public void delete(Long id) {
        findById(id);
        apostaRepository.deleteById(id);
    }

    @Transactional
    public Aposta update(Long id, Aposta partidaCreate) {
        Aposta aposta = findById(id);
        aposta.setStatus(partidaCreate.getStatus()); // alterando o status da aposta
        apostaRepository.save(aposta);
        return aposta;
    }

    public Aposta criarAposta(ApostaDTO dto, PartidaRepository partidaRepository, UsuarioRepository usuarioRepository) {
        dto.setDataAposta(LocalDateTime.now());
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId()).get();
        Partida partida = partidaRepository.findById(dto.getPartidaId()).get();
        Aposta aposta = new Aposta(dto, usuario, partida);
        return aposta;
    }
}
