package mx.unam.aragon.lau.tickets_proyecto.repository;

import mx.unam.aragon.lau.tickets_proyecto.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    
    // Para buscar un ticket específico por su folio (ej: TICK-20261019-001)
    Optional<Ticket> findByFolio(String folio);
}