package com.sisencuesta.controllers;

import com.sisencuesta.models.Encuesta;
import com.sisencuesta.services.EncuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/encuestas")
public class EncuestaController {

    @Autowired
    private EncuestaService encuestaService;

    @PostMapping
    public ResponseEntity<Encuesta>crearEncuesta(@RequestBody Encuesta encuesta) throws URISyntaxException {
        Encuesta nuevaEncuesta = encuestaService.crearEncuesta(encuesta.getTitulo());
        return ResponseEntity.created(new URI("/api/encuestas" + nuevaEncuesta.getId())).body(nuevaEncuesta);
    }

    @GetMapping
    public List<Encuesta>obtenerEncuesta(){
        return encuestaService.obtenerTodasLasEncuestas();
    }

    @GetMapping("/{encuestaId}")
    public ResponseEntity<Encuesta>obtenerDetallesEncuesta(@PathVariable Long encuestaId) {
        Optional<Encuesta>encuestaOptional = encuestaService.obtenerDetallesEncuesta(encuestaId);
        return  encuestaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{encuestaId}")
    public ResponseEntity<Encuesta>actualizarEncuesta(@PathVariable Long encuestaId, @RequestBody Encuesta encuesta) {
        Encuesta encuestaActualizada = encuestaService.actualizarEncuesta(encuestaId, encuesta.getTitulo());
        return  encuestaActualizada != null ? ResponseEntity.ok(encuestaActualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{encuestaId}"  )
    public ResponseEntity<Void> eliminarEncuesta(@PathVariable Long encuestaId) {
        encuestaService.eliminarEncuesta(encuestaId);
        return ResponseEntity.noContent().build();

    }
}
