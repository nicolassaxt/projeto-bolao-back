package nicolassaxt.com.github.projetobolao.service;

import nicolassaxt.com.github.projetobolao.controller.dto.PartidaCreateDTO;
import nicolassaxt.com.github.projetobolao.exception.PartidaNotFoundException;
import nicolassaxt.com.github.projetobolao.model.Partida;
import nicolassaxt.com.github.projetobolao.model.StatusPartida;
import nicolassaxt.com.github.projetobolao.model.Time;
import nicolassaxt.com.github.projetobolao.repository.PartidaRepository;
import nicolassaxt.com.github.projetobolao.repository.TimeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
public class PartidaService {
    private final PartidaRepository partidaRepository;

    public PartidaService(PartidaRepository partidaRepository) { //construtor para injeção de dependencia
        this.partidaRepository = partidaRepository;
    }


    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Partida> findAll(){
        return partidaRepository.findAll();
    }

//    private static String getUUID() {
//        return UUID.randomUUID().toString().replace("-", "");
//    } //Gerando ID randomico

    @Transactional(readOnly = true)
    public Partida findById(Long id) {
        return partidaRepository.findById(id).orElseThrow(() ->
                new PartidaNotFoundException(id)); //criar notfound para os outros atributos

    }
    @Transactional
    public Partida create(Partida partidaCreate) {
        partidaCreate.setStatus(StatusPartida.ND);
        //partidaCreate.setTimeAId();
        //partidaCreate.setTimeBId();
        partidaRepository.save(partidaCreate);
        return partidaCreate;
    }
    @Transactional
    public void delete(Long id) {
        findById(id);
        partidaRepository.deleteById(id);
    }

    @Transactional
    public Partida update(Long id, Partida partidaCreate) {
        Partida partida = findById(id);
        partida.setDataPartida(partidaCreate.getDataPartida()); //alterando a data da partida
        partida.setImgUrlPartida(partidaCreate.getImgUrlPartida());//alterar o url da imagem
        partida.setStatus(partidaCreate.getStatus()); // alterando o status da partida
        partida.setDataPartida(partidaCreate.getDataPartida());// alterando a data da partida
        partidaRepository.save(partida);
        return partida;
    }

        public Partida criarPartida(PartidaCreateDTO dto, TimeRepository timeRepository) {
        LocalDateTime dataDaPartida = this.formatDateTime(dto.getDataPartida());
        Time timeA = timeRepository.findById(dto.getTimeAId()).get();
        Time timeB = timeRepository.findById(dto.getTimeBId()).get();
        Partida partida = new Partida(dto, dataDaPartida, timeA, timeB);
        return  partida;
    }


    public LocalDateTime formatDateTime(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(data, formatter);
        return dateTime;
    }
}
