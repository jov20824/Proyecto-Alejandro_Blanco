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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alamesa.proyecto.dto.ApiResponse;
import com.alamesa.proyecto.dto.usuario.UsuarioRequestDto;
import com.alamesa.proyecto.dto.usuario.UsuarioResponseDto;
import com.alamesa.proyecto.service.UsuarioService;
import com.alamesa.proyecto.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Usuarios", description = "Api de los usuarios")
@RestController
@RequestMapping("/usuario")
@Slf4j
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@Operation(summary = "Buscar por id", description = "Buscar un usuario por id.", tags = {"usuario", "get"})
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UsuarioResponseDto>> findById(@PathVariable Long id) {
        log.info("Peticion para mostrar el usuario con id " + id);
        return ResponseUtil.response(service.findById(id), HttpStatus.ACCEPTED, "Mostrando el usuario");
    }

    @Operation(summary = "Buscar todos los usuarios", description = "Buscar todos los usuarios de la base de datos.", tags = {"usuario", "get"})
    @GetMapping()
    public ResponseEntity<ApiResponse<List<UsuarioResponseDto>>> findAll() {
        log.info("Petición para mostrar todos los usuarios");
        return ResponseUtil.response(service.findAll(), HttpStatus.ACCEPTED, "Mostrando todos los usuarios");
    }
    
    @Operation(summary = "Buscar todos los usuarios sin cliente", description = "Buscar todos los usuarios sin cliente de la base de datos.", tags = {"usuario", "get"})
    @GetMapping("/unasigned")
    public ResponseEntity<ApiResponse<List<UsuarioResponseDto>>> findByClienteIsNull() {
        log.info("Petición para mostrar todos los usuarios sin cliente asociado");
        return ResponseUtil.response(service.findByClienteIsNull(), HttpStatus.ACCEPTED, "Mostrando todos los usuarios sin cliente asociado");
    }


    @Operation(summary = "Crear un usuario", description = "Crear un usuario y añadirlo a la base de datos.", tags = {"usuario", "post"})
    @PostMapping()
    public ResponseEntity<ApiResponse<UsuarioResponseDto>> add(@RequestBody UsuarioRequestDto usuarioDto) {
        log.info("Petición para añadir un usuario");
        return ResponseUtil.response(service.add(usuarioDto), HttpStatus.CREATED, "Usuario creado con éxito");
    }

    @Operation(summary = "Modificar un usuario", description = "Buscar un usuario por id y modificarlo con nuevos campos.", tags = {"usuario", "put"})
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UsuarioResponseDto>> update(@PathVariable Long id, @RequestBody UsuarioRequestDto usuarioDto) {
        log.info("Petición para actualizar un usuario con el id " + id);
        return ResponseUtil.response(service.update(id, usuarioDto), HttpStatus.ACCEPTED, "Usuario actualizado con éxito");
    }

    @Operation(summary = "Eliminar por id", description = "Buscar un usuario por id y eliminarlo de la base de datos.", tags = {"usuario", "delete"})
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> delete(@PathVariable Long id) {
        log.info("Petición para eliminar un usuario con el id " + id);
        service.delete(id);
        return ResponseUtil.response(null, HttpStatus.NO_CONTENT, "Usuario eliminado con éxito");
    }
}
