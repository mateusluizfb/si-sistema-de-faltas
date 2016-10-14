package si.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
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

}
