package estudiantesapireconocimientofacialbackend.repository;

import estudiantesapireconocimientofacialbackend.model.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EstudianteRepository extends MongoRepository<Estudiante, Integer> {
    Optional<Estudiante> findByCodigo(String codigo);
    Optional<Estudiante> findByEmail(String email);

    boolean existsByCodigo(String codigo);
    boolean existsByEmail(String email);

    boolean existsByCodigoAndIdNot(String codigo, Integer id);
    boolean existsByEmailAndIdNot(String email, Integer id);
}