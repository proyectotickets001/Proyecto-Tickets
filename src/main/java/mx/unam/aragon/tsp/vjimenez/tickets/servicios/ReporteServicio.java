package mx.unam.aragon.tsp.vjimenez.tickets.servicios;

import java.util.ArrayList;
import java.util.List;

import mx.unam.aragon.tsp.vjimenez.tickets.dtos.ReporteDto;

public class ReporteServicio {

    private final List<ReporteDto> reportes = new ArrayList<>();

    // Crear reporte
    public ReporteDto crearReporte(ReporteDto reporte) {
        reportes.add(reporte);
        return reporte;
    }

    // Obtener todos los reportes
    public List<ReporteDto> obtenerReportes() {
        return reportes;
    }

    // Actualizar reporte
    public ReporteDto actualizarReporte(ReporteDto reporte) {

        for (int i = 0; i < reportes.size(); i++) {

            ReporteDto actual = reportes.get(i);

            if (actual.getFechaInicial().equals(reporte.getFechaInicial())
                    && actual.getFechaFinal().equals(reporte.getFechaFinal())
                    && actual.getAsignarA().equals(reporte.getAsignarA())) {

                reportes.set(i, reporte);
                return reporte;
            }
        }

        return null;
    }

    // Eliminar reporte
    public boolean eliminarReporte(
            String fechaInicial,
            String fechaFinal,
            String asignarA) {

        return reportes.removeIf(
                reporte -> reporte.getFechaInicial().equals(fechaInicial)
                        && reporte.getFechaFinal().equals(fechaFinal)
                        && reporte.getAsignarA().equals(asignarA));
    }
}