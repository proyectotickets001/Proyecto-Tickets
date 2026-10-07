package mx.unam.aragon.tsp.vjimenez.tickets.controllers;

import java.util.List;

import mx.unam.aragon.tsp.vjimenez.tickets.dtos.NotificacionDto;
import mx.unam.aragon.tsp.vjimenez.tickets.servicios.NotificacionServicio;

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
@RequestMapping("/api/v1/notificaciones")
public class NotificacionController {

    private final NotificacionServicio notificacionServicio;

    public NotificacionController() {
        this.notificacionServicio = new NotificacionServicio();
    }

    // CREAR NOTIFICACIÓN
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NotificacionDto crearNotificacion(
            @RequestBody NotificacionDto notificacion) {

        return notificacionServicio.crearNotificacion(notificacion);
    }

    // CONSULTAR NOTIFICACIONES
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<NotificacionDto> obtenerNotificaciones() {

        return notificacionServicio.obtenerNotificaciones();
    }

    // ACTUALIZAR NOTIFICACIÓN
    @PutMapping
    public ResponseEntity<NotificacionDto> actualizarNotificacion(
            @RequestBody NotificacionDto notificacion) {

        NotificacionDto notificacionActualizada = notificacionServicio.actualizarNotificacion(notificacion);

        if (notificacionActualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(notificacionActualizada);
    }

    // ELIMINAR NOTIFICACIÓN
    @DeleteMapping("/{tipo}/{fecha}")
    public ResponseEntity<Void> eliminarNotificacion(
            @PathVariable("tipo") String tipo,
            @PathVariable("fecha") String fecha) {

        boolean eliminada = notificacionServicio.eliminarNotificacion(tipo, fecha);

        if (!eliminada) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}