package mx.unam.aragon.tsp.vjimenez.tickets.servicios;

import java.util.ArrayList;
import java.util.List;

import mx.unam.aragon.tsp.vjimenez.tickets.dtos.TicketDto;

public class TicketServicio {

    private final List<TicketDto> tickets = new ArrayList<>();

    // Crear ticket
    public TicketDto crearTicket(TicketDto ticket) {
        tickets.add(ticket);
        return ticket;
    }

    // Obtener todos los tickets
    public List<TicketDto> obtenerTickets() {
        return tickets;
    }

    // Actualizar ticket
    public TicketDto actualizarTicket(TicketDto ticket) {

        for (int i = 0; i < tickets.size(); i++) {

            if (tickets.get(i).getNumeroSolicitud()
                    .equals(ticket.getNumeroSolicitud())) {

                tickets.set(i, ticket);
                return ticket;
            }
        }

        return null;
    }

    // Eliminar ticket
    public boolean eliminarTicket(String numeroSolicitud) {

        return tickets.removeIf(
                ticket -> ticket.getNumeroSolicitud()
                        .equals(numeroSolicitud));
    }
}