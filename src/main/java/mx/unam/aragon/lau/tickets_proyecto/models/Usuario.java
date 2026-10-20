package mx.unam.aragon.lau.tickets_proyecto.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String password;

    private String codigoVerificacion; // Aquí guardaremos el código que mandaremos por mail

    @Column(nullable = false)
    private Boolean verificado = false; // falso hasta que el usuario ingrese el código
}