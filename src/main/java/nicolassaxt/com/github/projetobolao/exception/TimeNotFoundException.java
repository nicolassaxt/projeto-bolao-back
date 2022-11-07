package nicolassaxt.com.github.projetobolao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class TimeNotFoundException extends RuntimeException {

    public TimeNotFoundException(String id) {
        super("Time not found with Id: " + id);
    }
}
