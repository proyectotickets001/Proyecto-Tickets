package mx.unam.aragon.lau.tickets_proyecto.controllers;

import mx.unam.aragon.lau.tickets_proyecto.dtos.UsuarioRegistroDto; // Asegúrate de que el nombre coincida con el tuyo
import mx.unam.aragon.lau.tickets_proyecto.models.Usuario;
import mx.unam.aragon.lau.tickets_proyecto.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController // Indica que esta clase responderá peticiones web (REST)
@RequestMapping("/api/usuarios") // Ruta base para todos los endpoints de aquí
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Inyección por constructor
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Endpoint para registrar un usuario nuevo.
     * URL: POST http://localhost:8080/api/usuarios/registrar
     */
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@RequestBody UsuarioRegistroDto dto) {
        try {
            Usuario nuevoUsuario = usuarioService.registrarUsuario(dto);
            return ResponseEntity.ok("Usuario registrado exitosamente. Se ha enviado un código de verificación al correo: " + nuevoUsuario.getCorreo());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    /**
     * clase que sirve para verificar el código enviado al correo 
     * 
     */
    @PostMapping("/verificar")
    public ResponseEntity<?> verificarCodigo(@RequestBody Map<String, String> request) {
        String correo = request.get("correo"); // sirve para obtener el correo del usuario
        String codigo = request.get("codigo"); // sirve para obtener el código enviado al correo

        boolean esValido = usuarioService.verificarCodigoLogin(correo, codigo);

        if (esValido) {
            return ResponseEntity.ok("Código verificado correctamente, sesion iniciada<3");
        } else {
            return ResponseEntity.badRequest().body("Código incorrecto o usuario no encontrado");
        }
    }
}