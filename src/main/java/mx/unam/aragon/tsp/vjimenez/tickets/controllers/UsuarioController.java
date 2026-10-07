package mx.unam.aragon.tsp.vjimenez.tickets.controllers;

import java.util.List;

import mx.unam.aragon.tsp.vjimenez.tickets.dtos.UsuarioDto;
import mx.unam.aragon.tsp.vjimenez.tickets.servicios.UsuarioServicio;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioServicio usuarioServicio;

    public UsuarioController() {
        this.usuarioServicio = new UsuarioServicio();
    }

    // CREAR USUARIO
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDto crearUsuario(@RequestBody UsuarioDto usuario) {
        return usuarioServicio.crearUsuario(usuario);
    }

    // CONSULTAR USUARIOS
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioDto> obtenerUsuarios() {
        return usuarioServicio.obtenerUsuarios();
    }

    // ACTUALIZAR USUARIO
    @PutMapping
    public ResponseEntity<UsuarioDto> actualizarUsuario(
            @RequestBody UsuarioDto usuario) {

        UsuarioDto usuarioActualizado = usuarioServicio.actualizarUsuario(usuario);

        if (usuarioActualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuarioActualizado);
    }

    // ELIMINAR USUARIO
    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> eliminarUsuario(
            @PathVariable("idUsuario") String idUsuario) {

        boolean eliminado = usuarioServicio.eliminarUsuario(idUsuario);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}