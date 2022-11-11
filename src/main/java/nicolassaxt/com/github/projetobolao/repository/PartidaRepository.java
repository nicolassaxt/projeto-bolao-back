package nicolassaxt.com.github.projetobolao.repository;

import nicolassaxt.com.github.projetobolao.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends JpaRepository<Partida , Long> {
}
