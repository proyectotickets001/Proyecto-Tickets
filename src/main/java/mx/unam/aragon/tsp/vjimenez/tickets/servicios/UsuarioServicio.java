package mx.unam.aragon.tsp.vjimenez.tickets.servicios;

import java.util.ArrayList;
import java.util.List;

import mx.unam.aragon.tsp.vjimenez.tickets.dtos.UsuarioDto;

public class UsuarioServicio {

    private final List<UsuarioDto> usuarios = new ArrayList<>();

    // Crear usuario
    public UsuarioDto crearUsuario(UsuarioDto usuario) {
        usuarios.add(usuario);
        return usuario;
    }

    // Obtener todos los usuarios
    public List<UsuarioDto> obtenerUsuarios() {
        return usuarios;
    }

    // Actualizar usuario
    public UsuarioDto actualizarUsuario(UsuarioDto usuario) {

        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i).getIdUsuario().equals(usuario.getIdUsuario())) {
                usuarios.set(i, usuario);
                return usuario;
            }
        }

        return null;
    }

    // Eliminar usuario
    public boolean eliminarUsuario(String idUsuario) {

        return usuarios.removeIf(
                usuario -> usuario.getIdUsuario().equals(idUsuario));
    }
}