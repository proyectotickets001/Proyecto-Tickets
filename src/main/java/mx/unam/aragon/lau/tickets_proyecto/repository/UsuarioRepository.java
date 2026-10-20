package mx.unam.aragon.lau.tickets_proyecto.repository;

import mx.unam.aragon.lau.tickets_proyecto.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    // Spring Boot leerá este nombre de método y escribirá el SQL: SELECT * FROM usuarios WHERE correo = ?
    Optional<Usuario> findByCorreo(String correo);
}