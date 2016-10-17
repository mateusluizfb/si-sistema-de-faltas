package si.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import si.entities.Membro;
import si.entities.Turma;

import java.util.List;

/**
 * Created by mateus on 05/10/16.
 */

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

    @Modifying //é preciso avisar o spring para executar um executeUpdate emvez de um execute apenas
    @Transactional //permite o Spring usar commit/rollback do transaciton do hibernate caso ele não consiga deletar ele volta
    @Query(nativeQuery = true, value = "" +
            "DELETE FROM Presenca p WHERE p.turma_id = ?1")
    void removePresencas(Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "" +
            "DELETE FROM Turma t WHERE t.id = ?1")
    void deleteTurma(Long id);

    @Query(nativeQuery = false, value = "" +
            "SELECT m " +
            "FROM Membro m " +
            "JOIN m.turmas t " +
            "WHERE t.id = ?1")
    List<Membro> findByTurma(Long id);

}
