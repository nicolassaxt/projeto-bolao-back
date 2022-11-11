package nicolassaxt.com.github.projetobolao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PartidaNotFoundException extends RuntimeException {
    public PartidaNotFoundException(Long id) {
        super("Partida not found with Id: " + id);
    }
}
