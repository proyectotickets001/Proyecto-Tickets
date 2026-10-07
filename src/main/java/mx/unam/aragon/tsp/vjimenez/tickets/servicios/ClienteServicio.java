package mx.unam.aragon.tsp.vjimenez.tickets.servicios;

import java.util.ArrayList;
import java.util.List;

import mx.unam.aragon.tsp.vjimenez.tickets.dtos.ClienteDto;

public class ClienteServicio {

    private final List<ClienteDto> clientes = new ArrayList<>();

    // Crear cliente
    public ClienteDto crearCliente(ClienteDto cliente) {
        clientes.add(cliente);
        return cliente;
    }

    // Obtener todos los clientes
    public List<ClienteDto> obtenerClientes() {
        return clientes;
    }

    // Actualizar cliente
    public ClienteDto actualizarCliente(ClienteDto cliente) {

        for (int i = 0; i < clientes.size(); i++) {

            if (clientes.get(i).getCorreo().equals(cliente.getCorreo())) {
                clientes.set(i, cliente);
                return cliente;
            }
        }

        return null;
    }

    // Eliminar cliente
    public boolean eliminarCliente(String correo) {
        return clientes.removeIf(
                cliente -> cliente.getCorreo().equals(correo));
    }
}