package mx.unam.aragon.tsp.vjimenez.tickets.dtos;

public class ReporteDto {

    private String urgencia;
    private String fechaInicial;
    private String fechaFinal;
    private String asignarA;

    public ReporteDto() {
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getAsignarA() {
        return asignarA;
    }

    public void setAsignarA(String asignarA) {
        this.asignarA = asignarA;
    }
}