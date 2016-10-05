package si.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import si.entities.Turma;

/**
 * Created by mateus on 05/10/16.
 */

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
