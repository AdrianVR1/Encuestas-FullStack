package com.sisencuesta.controllers;

import com.sisencuesta.models.Pregunta;
import com.sisencuesta.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/preguntas")

public class PreguntaController {
    @Autowired
    private PreguntaService preguntaService;

    @PostMapping("/agregar/{encuestaId}")
    public ResponseEntity<Pregunta>agregarPregunta(@PathVariable Long encuestaId, @RequestBody Pregunta pregunta) throws URISyntaxException {
        Pregunta nuevaPregunta = preguntaService.agregarPreguntaAEncuesta(encuestaId, pregunta.getContenido());
        return ResponseEntity.created(new URI("/api/preguntas" + nuevaPregunta.getId())).body(nuevaPregunta);
    }

        @GetMapping("/preguntaList/{encuestaId}")
    public List<Pregunta> obtenerPregunta(@PathVariable Long encuestaId){
        return preguntaService.obtenerPreguntaPorEncuesta(encuestaId);
    }

    @GetMapping("/{preguntaId}")
    public ResponseEntity<Pregunta>obtenerDetallesPregunta(@PathVariable Long preguntaId) {
        Optional<Pregunta> preguntaOptional = preguntaService.obtenerDetallesPregunta(preguntaId);
        return preguntaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{preguntaId}/encuesta/{encuestaId}")
    public ResponseEntity<Pregunta>actualizarPregunta(@PathVariable Long preguntaId, @RequestBody Pregunta pregunta, @PathVariable Long encuestaId) {
        Pregunta actualizarRespuesta = preguntaService.actualizarPregunta(preguntaId, pregunta.getContenido(),encuestaId);
        return  actualizarRespuesta != null ? ResponseEntity.ok(actualizarRespuesta) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{preguntaId}")
    public ResponseEntity<Void> eliminarPregunta(@PathVariable Long preguntaId) {
        preguntaService.eliminarPregunta(preguntaId);
        return ResponseEntity.noContent().build();

    }


}
