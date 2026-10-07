package mx.unam.aragon.tsp.vjimenez.tickets.controllers;

import java.util.List;

import mx.unam.aragon.tsp.vjimenez.tickets.dtos.ReporteDto;
import mx.unam.aragon.tsp.vjimenez.tickets.servicios.ReporteServicio;

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
@RequestMapping("/api/v1/reportes")
public class ReporteController {

    private final ReporteServicio reporteServicio;

    public ReporteController() {
        this.reporteServicio = new ReporteServicio();
    }

    // CREAR REPORTE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReporteDto crearReporte(@RequestBody ReporteDto reporte) {
        return reporteServicio.crearReporte(reporte);
    }

    // CONSULTAR REPORTES
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ReporteDto> obtenerReportes() {
        return reporteServicio.obtenerReportes();
    }

    // ACTUALIZAR REPORTE
    @PutMapping
    public ResponseEntity<ReporteDto> actualizarReporte(
            @RequestBody ReporteDto reporte) {

        ReporteDto reporteActualizado = reporteServicio.actualizarReporte(reporte);

        if (reporteActualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(reporteActualizado);
    }

    // ELIMINAR REPORTE
    @DeleteMapping("/{fechaInicial}/{fechaFinal}/{asignarA}")
    public ResponseEntity<Void> eliminarReporte(
            @PathVariable("fechaInicial") String fechaInicial,
            @PathVariable("fechaFinal") String fechaFinal,
            @PathVariable("asignarA") String asignarA) {

        boolean eliminado = reporteServicio.eliminarReporte(
                fechaInicial,
                fechaFinal,
                asignarA);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}