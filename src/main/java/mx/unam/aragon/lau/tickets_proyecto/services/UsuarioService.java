package mx.unam.aragon.lau.tickets_proyecto.services;

import mx.unam.aragon.lau.tickets_proyecto.dtos.UsuarioRegistroDto; // Asegúrate de que el nombre coincida con el tuyo
import mx.unam.aragon.lau.tickets_proyecto.models.Usuario;
import mx.unam.aragon.lau.tickets_proyecto.repository.UsuarioRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UsuarioService {

    // Al poner "final", Lombok sabe que debe inyectarlos automáticamente
    private final UsuarioRepository usuarioRepository;
    private final JavaMailSender mailSender;
    

    public UsuarioService(UsuarioRepository usuarioRepository, JavaMailSender mailSender) {
        this.usuarioRepository = usuarioRepository;
        this.mailSender = mailSender;
    }

    /**
     * se registra un usuario y genera un codigo
     */
    public Usuario registrarUsuario(UsuarioRegistroDto dto) {
        // Verificamos si el correo ya existe
        Optional<Usuario> usuarioExistente = usuarioRepository.findByCorreo(dto.getCorreo());
        if (usuarioExistente.isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }

        // se crea el usuario con los datos de dto
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(dto.getNombre());
        nuevoUsuario.setCorreo(dto.getCorreo());
        nuevoUsuario.setPassword(dto.getPassword());
        
        // Generamos el código aleatorio y lo asignamos
        String codigoGenerado = generarCodigoVerificacion();
        nuevoUsuario.setCodigoVerificacion(codigoGenerado);
        nuevoUsuario.setVerificado(false);

        // Guardamos en la base de datos
        Usuario usuarioGuardado = usuarioRepository.save(nuevoUsuario);

        // Enviamos el correo de verificación
        enviarCorreoVerificacion(usuarioGuardado.getCorreo(), codigoGenerado);

        return usuarioGuardado;
    }

    /**
     * verifica si coincide el codigo
     */
    public boolean verificarCodigoLogin(String correo, String codigoIngresado) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(correo);
        
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (usuario.getCodigoVerificacion() != null && usuario.getCodigoVerificacion().equals(codigoIngresado)) {
                usuario.setVerificado(true);
                usuario.setCodigoVerificacion(null); // Reseteamos por seguridad
                usuarioRepository.save(usuario);
                return true;
            }
        }
        return false;
    }

    /**
     * genera strign aleatorio de 6 digitoss
     */
    private String generarCodigoVerificacion() {
        Random random = new Random();
        int numero = 100000 + random.nextInt(900000); 
        return String.valueOf(numero);
    }

    /**
     * sirve para enviar correo de verificacion
     */
    private void enviarCorreoVerificacion(String correoDestino, String codigo) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(correoDestino);
        mensaje.setSubject("Tu código de verificación - Sistema de Tickets");
        mensaje.setText("Hola, tu código para iniciar sesión es: " + codigo + 
                        "\nPor favor ingrésalo en la aplicación para continuar.");
        
        mailSender.send(mensaje);
    }
}