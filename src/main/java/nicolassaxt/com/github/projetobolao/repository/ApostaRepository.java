package nicolassaxt.com.github.projetobolao.repository;

import nicolassaxt.com.github.projetobolao.model.Aposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApostaRepository extends JpaRepository<Aposta, Long> {
}
