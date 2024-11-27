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
import com.alamesa.proyecto.dto.plato.PlatoRequestDto;
import com.alamesa.proyecto.dto.plato.PlatoResponseDto;
import com.alamesa.proyecto.service.PlatoService;
import com.alamesa.proyecto.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Platos", description = "Api de los platos")
@RestController
@RequestMapping("/plato")
@Slf4j
public class PlatoController {

	@Autowired
    private PlatoService service;

    @Operation(summary = "Buscar por id", description = "Buscar un plato por id.", tags = {"plato", "get"})
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PlatoResponseDto>> findById(@PathVariable Long id) {
        log.info("Peticion para mostrar el plato con id " + id);
        return ResponseUtil.response(service.findById(id), HttpStatus.ACCEPTED, "Mostrando el plato");
    }

    @Operation(summary = "Buscar todos los platos", description = "Buscar todos los platos de la base de datos.", tags = {"plato", "get"})
    @GetMapping()
    public ResponseEntity<ApiResponse<List<PlatoResponseDto>>> findAll() {
        log.info("Petición para mostrar todos los platos");
        return ResponseUtil.response(service.findAll(), HttpStatus.ACCEPTED, "Mostrando todos los platos");
    }

    @Operation(summary = "Buscar todos los platos", description = "Buscar todos los platos de la base de datos ordenados por precio de forma ascendente.", tags = {"plato", "get"})
    @GetMapping("/precio/asc")
    public ResponseEntity<ApiResponse<List<PlatoResponseDto>>> findAllByOrderByPrecioAsc() {
        log.info("Petición para mostrar todos los platos ordenados por precio de manera ascendente");
        return ResponseUtil.response(service.findAllByOrderByPrecioAsc(), HttpStatus.ACCEPTED, "Mostrando todos los platos ordenados por precio de forma ascendente");
    }

    @Operation(summary = "Buscar todos los platos", description = "Buscar todos los platos de la base de datos ordenados por precio de forma descendente.", tags = {"plato", "get"})
    @GetMapping("/precio/desc")
    public ResponseEntity<ApiResponse<List<PlatoResponseDto>>> findAllByOrderByPrecioDesc() {
        log.info("Petición para mostrar todos los platos ordenados por precio de manera descendente");
        return ResponseUtil.response(service.findAllByOrderByPrecioDesc(), HttpStatus.ACCEPTED, "Mostrando todos los platos ordenados por precio de forma descendente");
    }

//    @Operation(summary = "Buscar los platos por categoria", description = "Buscar todos los platos de la base de datos pertenencientes a la categoria introducida.", tags = {"plato", "get"})
//    @GetMapping("categoria/{categoria}")
//    public ResponseEntity<ApiResponse<List<PlatoResponseDto>>> findPlatosByCategoria(@PathVariable Long categoria) {
//        log.info("Petición para mostrar los platos ordenados por la categoria " + categoria);
//        return ResponseUtil.response(service.findPlatosByCategoria(categoria), HttpStatus.ACCEPTED, "Mostrando los platos ordenados por la categoria " + categoria);
//    }

    @Operation(summary = "Crear un plato", description = "Crear un plato y añadirlo a la base de datos.", tags = {"plato", "post"})
    @PostMapping()
    public ResponseEntity<ApiResponse<PlatoResponseDto>> add(@RequestBody PlatoRequestDto platoDto) {
        log.info("Petición para añadir un plato");
        return ResponseUtil.response(service.add(platoDto), HttpStatus.CREATED, "Plato creado con éxito");
    }

    @Operation(summary = "Modificar un plato", description = "Buscar un plato por id y modificarlo con nuevos campos.", tags = {"plato", "put"})
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PlatoResponseDto>> update(@PathVariable Long id, @RequestBody PlatoRequestDto platoDto) {
        log.info("Petición para actualizar un plato con el id " + id);
        System.out.println(platoDto);
        return ResponseUtil.response(service.update(id, platoDto), HttpStatus.ACCEPTED, "Plato actualizado con éxito");
    }

    @Operation(summary = "Eliminar por id", description = "Buscar un plato por id y eliminarlo de la base de datos.", tags = {"plato", "delete"})
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> delete(@PathVariable Long id) {
        log.info("Petición para eliminar un plato con el id " + id);
        service.delete(id);
        return ResponseUtil.response(null, HttpStatus.NO_CONTENT, "Plato eliminado con éxito");
    }
}
