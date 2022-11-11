package nicolassaxt.com.github.projetobolao.repository;

import nicolassaxt.com.github.projetobolao.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {

}
