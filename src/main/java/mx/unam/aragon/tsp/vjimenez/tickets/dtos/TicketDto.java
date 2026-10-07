package mx.unam.aragon.tsp.vjimenez.tickets.dtos;

public class TicketDto {

    private String numeroSolicitud;
    private String personaUsuaria;
    private String urgencia;
    private String prioridad;
    private String descripcion;
    private String fechaCreacion;
    private String fechaEstimadaSolucion;
    private String grupoAsignacion;
    private String asignadoA;
    private String descripcionBreve;
    private String detalles;
    private String requerimientoServicio;
    private String quienGeneraReporte;

    public TicketDto() {
    }

    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public String getPersonaUsuaria() {
        return personaUsuaria;
    }

    public void setPersonaUsuaria(String personaUsuaria) {
        this.personaUsuaria = personaUsuaria;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaEstimadaSolucion() {
        return fechaEstimadaSolucion;
    }

    public void setFechaEstimadaSolucion(String fechaEstimadaSolucion) {
        this.fechaEstimadaSolucion = fechaEstimadaSolucion;
    }

    public String getGrupoAsignacion() {
        return grupoAsignacion;
    }

    public void setGrupoAsignacion(String grupoAsignacion) {
        this.grupoAsignacion = grupoAsignacion;
    }

    public String getAsignadoA() {
        return asignadoA;
    }

    public void setAsignadoA(String asignadoA) {
        this.asignadoA = asignadoA;
    }

    public String getDescripcionBreve() {
        return descripcionBreve;
    }

    public void setDescripcionBreve(String descripcionBreve) {
        this.descripcionBreve = descripcionBreve;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getRequerimientoServicio() {
        return requerimientoServicio;
    }

    public void setRequerimientoServicio(String requerimientoServicio) {
        this.requerimientoServicio = requerimientoServicio;
    }

    public String getQuienGeneraReporte() {
        return quienGeneraReporte;
    }

    public void setQuienGeneraReporte(String quienGeneraReporte) {
        this.quienGeneraReporte = quienGeneraReporte;
    }
}