package nicolassaxt.com.github.projetobolao.service;

import nicolassaxt.com.github.projetobolao.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private static Map<String, Usuario> usuarioMap = new HashMap();
    static {
        var id = getUUID();
        Usuario usuario = new Usuario(id, "Nicolas", "nicolas@teste.com", "1234", "Nicolas teste dos Santos");
        usuarioMap.put(id, usuario);
    }

    public List<Usuario> findAll(){
        return usuarioMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
