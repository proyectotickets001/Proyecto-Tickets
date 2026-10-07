package mx.unam.aragon.tsp.vjimenez.tickets.controllers;

import java.util.List;

import mx.unam.aragon.tsp.vjimenez.tickets.dtos.TicketDto;
import mx.unam.aragon.tsp.vjimenez.tickets.servicios.TicketServicio;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {

    private final TicketServicio ticketServicio;

    public TicketController() {
        this.ticketServicio = new TicketServicio();
    }

    // CREAR TICKET
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TicketDto crearTicket(@RequestBody TicketDto ticket) {
        return ticketServicio.crearTicket(ticket);
    }

    // CONSULTAR TICKETS
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TicketDto> obtenerTickets() {
        return ticketServicio.obtenerTickets();
    }

    // ACTUALIZAR TICKET
    @PutMapping
    public ResponseEntity<TicketDto> actualizarTicket(
            @RequestBody TicketDto ticket) {

        TicketDto ticketActualizado = ticketServicio.actualizarTicket(ticket);

        if (ticketActualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ticketActualizado);
    }

    // ELIMINAR TICKET
    @DeleteMapping("/{numeroSolicitud}")
    public ResponseEntity<Void> eliminarTicket(
            @PathVariable("numeroSolicitud") String numeroSolicitud) {

        boolean eliminado = ticketServicio.eliminarTicket(numeroSolicitud);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}