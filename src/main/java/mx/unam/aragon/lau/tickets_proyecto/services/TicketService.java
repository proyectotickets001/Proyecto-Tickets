package mx.unam.aragon.lau.tickets_proyecto.services;

import mx.unam.aragon.lau.tickets_proyecto.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TicketService {


    private final TicketRepository ticketRepository; 
    

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


    /**
     * Regla de negocio para genrear un folio único para cada ticket nuevo
     */
    public String generarFolioUnico() {
        String fechaHoraStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        long conteoActual = ticketRepository.count();
        long idIncremental = conteoActual + 1;
        String idFormateado = String.format("%03d", idIncremental);
        
        return "TIK-" + fechaHoraStr + "-" + idFormateado;
    }
}