package si.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import si.util.DatabaseJDBC;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by mateus on 13/10/16.
 */

@Repository
public class CustomMembroRepository {

    @Transactional
    public void deleteAll(Long membroID){

        try (Connection connection = DatabaseJDBC.getConnection()) {

            try(PreparedStatement ps = connection.prepareStatement("" +
                    "DELETE FROM Turma_has_membros th WHERE th.membro_id = ?")){

                ps.setLong(1, membroID);

                ps.execute();
            }

            try(PreparedStatement ps = connection.prepareStatement("" +
                    "DELETE FROM Presenca p WHERE p.membro_id = ?")){

                ps.setLong(1, membroID);

                ps.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Transactional
    public void delete(Long membroID){
        try (Connection connection =DatabaseJDBC.getConnection()) {

            try(PreparedStatement ps = connection.prepareStatement("" +
                    "DELETE FROM Membro m WHERE m.id = ?")){

                ps.setLong(1, membroID);

                ps.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
