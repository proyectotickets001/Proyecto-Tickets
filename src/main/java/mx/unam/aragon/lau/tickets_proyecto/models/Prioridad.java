package mx.unam.aragon.lau.tickets_proyecto.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity // sirve para decirle a java que es una bd
@Table(name = "prioridades") // Nombrea tabla en mysql
@Data
public class Prioridad {
    
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nombre; //Baja, Media, Alta, Urgente
}