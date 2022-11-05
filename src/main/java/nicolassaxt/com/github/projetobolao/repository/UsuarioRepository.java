package nicolassaxt.com.github.projetobolao.repository;

import nicolassaxt.com.github.projetobolao.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
