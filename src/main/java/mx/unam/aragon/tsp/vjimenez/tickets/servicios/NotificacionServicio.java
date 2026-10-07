package mx.unam.aragon.tsp.vjimenez.tickets.servicios;

import java.util.ArrayList;
import java.util.List;

import mx.unam.aragon.tsp.vjimenez.tickets.dtos.NotificacionDto;

public class NotificacionServicio {

    private final List<NotificacionDto> notificaciones = new ArrayList<>();

    // Crear notificación
    public NotificacionDto crearNotificacion(NotificacionDto notificacion) {
        notificaciones.add(notificacion);
        return notificacion;
    }

    // Obtener todas las notificaciones
    public List<NotificacionDto> obtenerNotificaciones() {
        return notificaciones;
    }

    // Actualizar notificación
    public NotificacionDto actualizarNotificacion(NotificacionDto notificacion) {

        for (int i = 0; i < notificaciones.size(); i++) {

            NotificacionDto actual = notificaciones.get(i);

            if (actual.getTipo().equals(notificacion.getTipo())
                    && actual.getFecha().equals(notificacion.getFecha())) {

                notificaciones.set(i, notificacion);
                return notificacion;
            }
        }

        return null;
    }

    // Eliminar notificación
    public boolean eliminarNotificacion(String tipo, String fecha) {
        return notificaciones.removeIf(
                notificacion -> notificacion.getTipo().equals(tipo)
                        && notificacion.getFecha().equals(fecha));
    }
}