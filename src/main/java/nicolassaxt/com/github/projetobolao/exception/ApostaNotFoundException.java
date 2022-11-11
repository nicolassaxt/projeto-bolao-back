package nicolassaxt.com.github.projetobolao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ApostaNotFoundException extends RuntimeException {
    public ApostaNotFoundException(Long id) {
        super("Aposta not found with Id: " + id);
    }
}
