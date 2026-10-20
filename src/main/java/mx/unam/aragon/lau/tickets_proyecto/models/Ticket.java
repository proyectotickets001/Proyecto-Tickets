package mx.unam.aragon.lau.tickets_proyecto.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Data
public class Ticket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String folio; // Aquí guardaremos el folio que se genera automáticamente al crear un ticket

    // usuario puede tener muchos tickets
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String problema;

    private String rutaArchivo; // guardara la evidencia que se suba al crear el ticket

    @Column(nullable = false)
    private String tipoProblema;

    // un ticket tiene una prioridad
    @ManyToOne
    @JoinColumn(name = "prioridad_id", nullable = false)
    private Prioridad prioridad;

    // un ticket tiene un estado
    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false)
    private Estado estado;

    @Column(nullable = false)
    private LocalDateTime fechaInicial;

    private LocalDateTime fechaFinal;
}
