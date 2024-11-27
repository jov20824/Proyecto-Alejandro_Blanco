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
import com.alamesa.proyecto.dto.pedido.PedidoRequestDto;
import com.alamesa.proyecto.dto.pedido.PedidoResponseDto;
import com.alamesa.proyecto.service.PedidoService;
import com.alamesa.proyecto.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Pedidos", description = "Api de los pedidos")
@RestController
@RequestMapping("/pedido")
@Slf4j
public class PedidoController {

	@Autowired
    private PedidoService service;

    @Operation(summary = "Buscar por id", description = "Buscar un pedido por id.", tags = {"pedido", "get"})
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PedidoResponseDto>> findById(@PathVariable Long id) {
        log.info("Peticion para mostrar el pedido con id " + id);
        return ResponseUtil.response(service.findById(id), HttpStatus.ACCEPTED, "Mostrando el pedido");
    }
    
    @Operation(summary = "Buscar por email", description = "Buscar una lista de pedidos de un usuario.", tags = {"pedido", "get"})
    @GetMapping("/usuario/{email}")
    public ResponseEntity<ApiResponse<List<PedidoResponseDto>>> findByClienteUsuarioEmail(@PathVariable String email) {
        log.info("Peticion para mostrar los pedidos del usuario con el email " + email);
        return ResponseUtil.response(service.findByClienteUsuarioEmail(email), HttpStatus.ACCEPTED, "Mostrando v");
    }
    
    @Operation(summary = "Buscar por id", description = "Buscar una lista de pedidos que contengan un plato.", tags = {"pedido", "get"})
    @GetMapping("/plato/{idPlato}")
    public ResponseEntity<ApiResponse<List<PedidoResponseDto>>> findDistinctByContienePlatoId(@PathVariable Long idPlato) {
        log.info("Peticion para mostrar los pedidos que contengan el plato con id " + idPlato);
        return ResponseUtil.response(service.findDistinctByContienePlatoId(idPlato), HttpStatus.ACCEPTED, "Mostrando los pedidos");
    }

    @Operation(summary = "Buscar todos los pedidos", description = "Buscar todos los pedidos de la base de datos.", tags = {"pedido", "get"})
    @GetMapping()
    public ResponseEntity<ApiResponse<List<PedidoResponseDto>>> findAll() {
        log.info("Petición para mostrar todos los pedidos");
        return ResponseUtil.response(service.findAll(), HttpStatus.ACCEPTED, "Mostrando todos los pedidos");
    }
    
    @Operation(summary = "Buscar todos los pedidos ordenados por fecha de manera ascendente", description = "Buscar todos los pedidos de la base de datos ordenados por fecha de manera ascendente.", tags = {"pedido", "get"})
    @GetMapping("/fecha/asc")
    public ResponseEntity<ApiResponse<List<PedidoResponseDto>>> findAllByOrderByFechaRealizadoAsc() {
        log.info("Petición para mostrar todos los pedidos ordenados por fecha de manera ascendente");
        return ResponseUtil.response(service.findAllByOrderByFechaRealizadoAsc(), HttpStatus.ACCEPTED, "Mostrando todos los pedidos ordenados por fecha de manera ascendente");
    }
    
    @Operation(summary = "Buscar todos los pedidos ordenados por fecha de manera descendente", description = "Buscar todos los pedidos de la base de datos ordenados por fecha de manera descendente.", tags = {"pedido", "get"})
    @GetMapping("/fecha/desc")
    public ResponseEntity<ApiResponse<List<PedidoResponseDto>>> findAllByOrderByFechaRealizadoDesc() {
        log.info("Petición para mostrar todos los pedidos");
        return ResponseUtil.response(service.findAllByOrderByFechaRealizadoDesc(), HttpStatus.ACCEPTED, "Mostrando todos los pedidos ordenados por fecha de manera descendente");
    }

    @Operation(summary = "Crear un pedido", description = "Crear un pedido y añadirlo a la base de datos.", tags = {"pedido", "post"})
    @PostMapping()
    public ResponseEntity<ApiResponse<PedidoResponseDto>> add(@RequestBody PedidoRequestDto pedidoDto) {
        log.info("Petición para añadir un pedido");
        return ResponseUtil.response(service.add(pedidoDto), HttpStatus.CREATED, "Pedido creado con éxito");
    }

    @Operation(summary = "Modificar un pedido", description = "Buscar un pedido por id y modificarlo con nuevos campos.", tags = {"pedido", "put"})
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PedidoResponseDto>> update(@PathVariable Long id, @RequestBody PedidoRequestDto pedidoDto) {
    	System.out.println(pedidoDto);
        log.info("Petición para actualizar un pedido con el id " + id);
        return ResponseUtil.response(service.update(id, pedidoDto), HttpStatus.ACCEPTED, "Pedido actualizado con éxito");
    }

    @Operation(summary = "Eliminar por id", description = "Buscar un pedido por id y eliminarlo de la base de datos.", tags = {"pedido", "delete"})
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> delete(@PathVariable Long id) {
        log.info("Petición para eliminar un pedido con el id " + id);
        service.delete(id);
        return ResponseUtil.response(null, HttpStatus.NO_CONTENT, "Pedido eliminado con éxito");
    }
}

