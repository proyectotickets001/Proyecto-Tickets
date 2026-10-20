package mx.unam.aragon.lau.tickets_proyecto.dtos;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class TicketRequestDto {
    private String correoUsuario; // para asociar el ticket al usuario
    private String problema; // para describir el problema que se esta reportando
    private MultipartFile archivoEvidencia; // Archivo que se va a djuntar como evidencia del problema
    private String tipoProblema; //Ssaber el tipo de problema que se esta reportando 
    private Integer prioridadId; // para saber la prioridad del ticket
    private LocalDateTime fechaInicial; 
    private LocalDateTime fechaFinal;

}
