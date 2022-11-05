package nicolassaxt.com.github.projetobolao.service;

import nicolassaxt.com.github.projetobolao.exception.UsuarioNotFoundException;
import nicolassaxt.com.github.projetobolao.model.Usuario;
import nicolassaxt.com.github.projetobolao.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsuarioService {


   private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) { //construtor para injeção de dependencia
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    } //Gerando ID randomico

    @Transactional(readOnly = true)
    public Usuario findById(String id) {
       return usuarioRepository.findById(id).orElseThrow(() ->
               new UsuarioNotFoundException(id)); //criar notfound para os outros atributos

    }
    @Transactional
    public Usuario create(Usuario usuarioCreate) {
        String uuid = getUUID();
        usuarioCreate.setId(uuid);
        usuarioCreate.setUser_join_date(LocalDateTime.now());
        usuarioRepository.save(usuarioCreate);
        return usuarioCreate;
    }
    @Transactional
    public void delete(String id) {
        findById(id);
        usuarioRepository.deleteById(id);
    }

    @Transactional
    public Usuario update(String id, Usuario usuarioCreate) {
        Usuario usuario = findById(id);
        usuario.setUser_name(usuarioCreate.getUser_name()); //alterando o user name
        usuario.setUser_full_name(usuarioCreate.getUser_full_name());//alterar o nome completo
        usuario.setUser_password(usuarioCreate.getUser_password()); //alterar a senha
        usuarioRepository.save(usuario);
        return usuario;
    }
}
