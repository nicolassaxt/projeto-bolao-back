package nicolassaxt.com.github.projetobolao.service;

import nicolassaxt.com.github.projetobolao.exception.TimeNotFoundException;
import nicolassaxt.com.github.projetobolao.model.Time;
import nicolassaxt.com.github.projetobolao.repository.TimeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.UUID;

@Service
public class TimeService {
    private final TimeRepository timeRepository;


    public TimeService(TimeRepository timeRepository) { //construtor para injeção de dependencia
        this.timeRepository = timeRepository;
    }


    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Time> findAll(){
        return timeRepository.findAll();
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    } //Gerando ID randomico

    @Transactional(readOnly = true)
    public Time findById(String id) {
        return timeRepository.findById(id).orElseThrow(() ->
                new TimeNotFoundException(id)); //criar notfound para os outros atributos

    }
    @Transactional
    public Time create(Time timeCreate) {
        String uuid = getUUID();
        timeCreate.setId(uuid);
        timeRepository.save(timeCreate);
        return timeCreate;
    }
    @Transactional
    public void delete(String id) {
        findById(id);
        timeRepository.deleteById(id);
    }

    @Transactional
    public Time update(String id, Time timeCreate) {
        Time time = findById(id);
        time.setNomeTime(timeCreate.getNomeTime()); //alterando o nome do time
        time.setImgUrlTime(timeCreate.getImgUrlTime());//alterar a url do time
        time.setGrupo(timeCreate.getGrupo()); //alterar o grupo do time
        timeRepository.save(time);
        return time;
    }

}
