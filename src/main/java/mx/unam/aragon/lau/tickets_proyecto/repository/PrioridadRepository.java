package mx.unam.aragon.lau.tickets_proyecto.repository;

import mx.unam.aragon.lau.tickets_proyecto.models.Prioridad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PrioridadRepository extends JpaRepository<Prioridad, Integer> {
    
    // Útil para buscar si ya existe la prioridad "Alta", "Media", etc.
    Optional<Prioridad> findByNombre(String nombre);
}