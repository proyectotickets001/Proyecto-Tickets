package mx.unam.aragon.lau.tickets_proyecto.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "estados")
@Data
public class Estado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nombre; //Abierto, Proceso, Terminado, Pausa, Rechazado
}
