package com.alamesa.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alamesa.proyecto.dto.ApiResponse;
import com.alamesa.proyecto.dto.cliente.ClienteRequestDto;
import com.alamesa.proyecto.dto.cliente.ClienteResponseDto;
import com.alamesa.proyecto.service.ClienteService;
import com.alamesa.proyecto.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Clientes", description = "Api de los clientes")
@RestController
@RequestMapping("/cliente")
@Slf4j
public class ClienteController {

	@Autowired
    private ClienteService clienteService;

    @Operation(summary = "Buscar por id", description = "Buscar un cliente por id.", tags = {"cliente", "get"})
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ClienteResponseDto>> findById(@PathVariable Long id) {
        log.info("Peticion para mostrar el cliente con id " + id);
        return ResponseUtil.response(clienteService.findById(id), HttpStatus.ACCEPTED, "Mostrando el cliente");
    }

    @Operation(summary = "Buscar todos los clientes", description = "Buscar todos los clientes de la base de datos.", tags = {"cliente", "get"})
    @GetMapping
    public ResponseEntity<ApiResponse<List<ClienteResponseDto>>> findAll() {
        log.info("Petición para mostrar todos los clientes");
        return ResponseUtil.response(clienteService.findAll(), HttpStatus.ACCEPTED, "Mostrando todos los clientes");
    }
    
    @Operation(summary = "Buscar todos los clientes por numero de pedidos en orden ascendente", description = "Buscar todos los clientes por numero de pedidos en orden ascendente de la base de datos.", tags = {"cliente", "get"})
    @GetMapping("/asc")
    public ResponseEntity<ApiResponse<List<ClienteResponseDto>>> findAllOrderByNumeroDePedidosAsc() {
        log.info("Petición para mostrar todos los clientes por numero de pedidos en orden ascendente");
        return ResponseUtil.response(clienteService.findAllOrderByNumeroDePedidosAsc(), HttpStatus.ACCEPTED, "todos los clientes por numero de pedidos en orden ascendente");
    }
    
    @Operation(summary = "Buscar todos los clientes por numero de pedidos en orden descendente", description = "Buscar todos los clientes por numero de pedidos en orden descendente de la base de datos.", tags = {"cliente", "get"})
    @GetMapping("/desc")
    public ResponseEntity<ApiResponse<List<ClienteResponseDto>>> findAllOrderByNumeroDePedidosDesc() {
        log.info("Petición para mostrar todos los clientes por numero de pedidos en orden descendente");
        return ResponseUtil.response(clienteService.findAllOrderByNumeroDePedidosDesc(), HttpStatus.ACCEPTED, "Mostrando todos los clientes por numero de pedidos en orden descendente");
    }

    @Operation(summary = "Crear un cliente.", description = "Crear un cliente y añadirlo a la base de datos.", tags = {"cliente", "post"})
    @PostMapping
    public ResponseEntity<ApiResponse<ClienteResponseDto>> add(@RequestBody ClienteRequestDto dto) {
        log.info("Petición para añadir un cliente");
        return ResponseUtil.response(clienteService.add(dto), HttpStatus.CREATED, "Cliente creado con éxito");
    }

    @Operation(summary = "Modificar un cliente", description = "Buscar un cliente por id y modificarlo con los campos nuevos.", tags = {"cliente", "put"})
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ClienteResponseDto>> update(@PathVariable Long id, @RequestBody ClienteRequestDto dto) {
        log.info("Petición para actualizar un cliente con el id " + id);
        return ResponseUtil.response(clienteService.update(id, dto), HttpStatus.ACCEPTED, "Cliente actualizado con éxito");
    }

    @Operation(summary = "Borrar un cliente", description = "Buscar un cliente por id y eliminarlo de la base de datos.", tags = {"cliente", "delete"})
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> delete(@PathVariable Long id) {
        log.info("Petición para eliminar un cliente con el id " + id);
        clienteService.delete(id);
        return ResponseUtil.response(null, HttpStatus.NO_CONTENT, "Cliente eliminado con éxito");
    }
}
