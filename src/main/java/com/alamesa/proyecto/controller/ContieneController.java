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
import com.alamesa.proyecto.dto.contiene.ContieneRequestDto;
import com.alamesa.proyecto.dto.contiene.ContieneResponseDto;
import com.alamesa.proyecto.service.ContieneService;
import com.alamesa.proyecto.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Contiene", description = "Api de los platos dentro de los pedidos")
@RestController
@RequestMapping("/contiene")
@Slf4j
public class ContieneController {

	@Autowired
    private ContieneService service;

    @Operation(summary = "Buscar por id", description = "Buscar una reseña de producto por id.", tags = {"contiene", "get"})
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ContieneResponseDto>> findById(@PathVariable Long id) {
        log.info("Peticion para mostrar el usuario_producto (resenia) con id " + id);
        return ResponseUtil.response(service.findById(id), HttpStatus.ACCEPTED, "Mostrando la reseña de producto");
    }

    @Operation(summary = "Buscar todas las reseñas de productos.", description = "Buscar todas las reseñas de productos de la base de datos", tags = {"contiene", "get"})
    @GetMapping()
    public ResponseEntity<ApiResponse<List<ContieneResponseDto>>> findAll() {
        log.info("Petición para mostrar todos los usuario_productos (resenias)");
        return ResponseUtil.response(service.findAll(), HttpStatus.ACCEPTED, "Mostrando todas las reseñas de productos");
    }

//    @Operation(summary = "Buscar todas las reseñas de productos ordenadas.", description = "Buscar todas las reseñas de productos de la base de datos ordenadas por su fecha de publicacion de forma ascendente", tags = {"contiene", "get"})
//    @GetMapping("/fechaSubida/asc")
//    public ResponseEntity<ApiResponse<List<ContieneResponseDto>>> findAllOrderByFechaPublicacionAsc() {
//        log.info("Petición para mostrar todos los usuario_producto (resenias) ordenados por fecha de publicacion en orden ascendente");
//        return ResponseUtil.response(service.findAllByOrderByFechaPublicacionAsc(), HttpStatus.ACCEPTED, "Mostrando todas las reseñas de productos ordenadas por fecha de publicacion en orden ascendente");
//    }
//
//    @Operation(summary = "Buscar todas las reseñas de productos ordenadas.", description = "Buscar todas las reseñas de productos de la base de datos ordenadas por su fecha de publicacion de forma descendente", tags = {"contiene", "get"})
//    @GetMapping("/fechaSubida/desc")
//    public ResponseEntity<ApiResponse<List<ContieneResponseDto>>> findAllOrderByFechaPublicacionDesc() {
//        log.info("Petición para mostrar todos los usuario_producto (resenias) ordenados por fecha de publicacion en orden descendente");
//        return ResponseUtil.response(service.findAllByOrderByFechaPublicacionDesc(), HttpStatus.ACCEPTED, "Mostrando todas las reseñas de productos ordenadas por fecha de publicacion en orden descendente");
//    }

    @Operation(summary = "Crear una reseña", description = "Crea una reseña recibiendo el usuario que la escribe, sobre que producto y la valoracion que le da. Tambien se puede escribir un texto de reseña", tags = {"contiene", "post"})
    @PostMapping()
    public ResponseEntity<ApiResponse<ContieneResponseDto>> add(@RequestBody ContieneRequestDto contieneRequestDto) {
        log.info("Petición para añadir un usuario_producto (resenia)");
        return ResponseUtil.response(service.add(contieneRequestDto), HttpStatus.CREATED, "Reseña de producto creada con éxito");
    }

    @Operation(summary = "Modificar una reseña", description = "Buscar una reseña de producto por id y la modifica, se puede cambiar la valoracion y el texto de reseña.", tags = {"contiene", "put"})
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ContieneResponseDto>> update(@PathVariable Long id,
                                                                           @RequestBody ContieneRequestDto cafeteriaDto) {
        log.info("Petición para actualizar un usuario_producto (resenia) con el id" + id);
        return ResponseUtil.response(service.update(id, cafeteriaDto), HttpStatus.ACCEPTED, "Reseña de producto actualizada con éxito");
    }
    
    
    @Operation(summary = "Borrar una reseña", description = "Buscar una reseña de producto por id y eliminarla.", tags = {"contiene", "delete"})
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> delete(@PathVariable Long id) {
        log.info("Petición para eliminar un usuario_producto (resenia) con el id" + id);
        service.delete(id);
        return ResponseUtil.response(null, HttpStatus.NO_CONTENT, "Reseña de producto eliminada con éxito");
    }
}
