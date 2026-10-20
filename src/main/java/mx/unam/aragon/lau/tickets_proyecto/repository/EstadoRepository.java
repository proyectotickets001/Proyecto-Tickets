package mx.unam.aragon.lau.tickets_proyecto.repository;

import mx.unam.aragon.lau.tickets_proyecto.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
    
    // Útil para buscar si ya existe el estado "Abierto", "En Proceso", etc.
    Optional<Estado> findByNombre(String nombre);
}
