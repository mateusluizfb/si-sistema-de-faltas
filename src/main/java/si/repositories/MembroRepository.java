package si.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import si.entities.Membro;
import si.enums.TipoPerfil;

import java.util.List;

/**
 * Created by mateus on 05/10/16.
 */

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long>{

    List<Membro> findAllByTipoPerfilIn(TipoPerfil... tipoPerfil);

//    @Modifying
//    @Transactional
//    @Query("DELETE FROM Turma_has_membros th WHERE th.membro_id = ?1")
//    void deleteFromRelational(Long membroID);
//
//    @Modifying
//    @Transactional
//    @Query("DELETE FROM Presenca p WHERE p.membro_id = ?1")
//    void deleteFromPresenca(Long membroID);

}
