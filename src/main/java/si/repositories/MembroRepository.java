package si.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import si.entities.Membro;
import si.enums.TipoPerfil;

import java.util.List;

/**
 * Created by mateus on 05/10/16.
 */

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long>{

    List<Membro> findAllByTipoPerfilIn(TipoPerfil... tipoPerfil);

    @Query(nativeQuery = false, value = "" +
            "SELECT m " +
            "FROM Membro m " +
            "JOIN m.turmas t " +
            "WHERE t.id = ?1")
    List<Membro> findByTurma(Long id);

    @Query(nativeQuery = true, value = "" +
            "SELECT \n" +
            "count(p.id)\n" +
            "FROM Membro m\n" +
            "INNER JOIN PRESENCA p\n" +
            "on p.membro_id = m.id\n" +
            "INNER JOIN (SELECT * FROM Turma t WHERE t.id = ?1) t\n" +
            "on t.id = p.turma_id\n" +
            "WHERE m.id = ?2\n" +
            "group by (m.id, t.id)")
    Long findNoPresencas(Long turmaId, Long membroId);
}
