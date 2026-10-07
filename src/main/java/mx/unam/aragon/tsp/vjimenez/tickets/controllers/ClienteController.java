package mx.unam.aragon.tsp.vjimenez.tickets.controllers;

import java.util.List;

import mx.unam.aragon.tsp.vjimenez.tickets.dtos.ClienteDto;
import mx.unam.aragon.tsp.vjimenez.tickets.servicios.ClienteServicio;

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
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private final ClienteServicio clienteServicio;

    public ClienteController() {
        this.clienteServicio = new ClienteServicio();
    }

    // CREAR CLIENTE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDto crearCliente(@RequestBody ClienteDto cliente) {
        return clienteServicio.crearCliente(cliente);
    }

    // CONSULTAR CLIENTES
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteDto> obtenerClientes() {
        return clienteServicio.obtenerClientes();
    }

    // ACTUALIZAR CLIENTE
    @PutMapping
    public ResponseEntity<ClienteDto> actualizarCliente(
            @RequestBody ClienteDto cliente) {

        ClienteDto clienteActualizado = clienteServicio.actualizarCliente(cliente);

        if (clienteActualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(clienteActualizado);
    }

    // ELIMINAR CLIENTE
    @DeleteMapping("/{correo}")
    public ResponseEntity<Void> eliminarCliente(
            @PathVariable("correo") String correo) {

        boolean eliminado = clienteServicio.eliminarCliente(correo);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}