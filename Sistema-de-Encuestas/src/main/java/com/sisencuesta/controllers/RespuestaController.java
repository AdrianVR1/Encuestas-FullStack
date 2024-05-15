package com.sisencuesta.controllers;

import com.sisencuesta.models.Respuesta;
import com.sisencuesta.services.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/respuestas")

public class RespuestaController {
    @Autowired
    private RespuestaService respuestaService;

    @PostMapping("/agregar/{preguntaId}")
    public ResponseEntity<Respuesta>agregarRespuestaAPregunta(@PathVariable Long preguntaId, @RequestBody Respuesta respuesta) throws URISyntaxException {
        Respuesta nuevaRespuesta = respuestaService.agregarRespuestaAPregunta(preguntaId, respuesta.getContenido());
        return ResponseEntity.created(new URI("/api/respuestas" + nuevaRespuesta.getId())).body(nuevaRespuesta);
    }

    @GetMapping("/pregunta/{preguntaId}")
    public List<Respuesta>obtenerRespuestasPorPreguntas(@PathVariable Long preguntaId){
        return respuestaService.obtenerRespuestaPorPregunta(preguntaId);
    }

    @GetMapping("/{respuestaId}")
    public ResponseEntity<Respuesta>obtenerDetalles(@PathVariable Long respuestaId) {
        Optional<Respuesta> optionalRespuesta = respuestaService.obtenerDetallesRespuesta(respuestaId);
        return optionalRespuesta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{respuestaId}")
    public ResponseEntity<Respuesta>actualizarRespuesta(@PathVariable Long respuestaId, @RequestBody Respuesta respuesta) {
        Respuesta actualizarRespuesta = respuestaService.actualizarRespuesta(respuestaId, respuesta.getContenido());
        return  actualizarRespuesta != null ? ResponseEntity.ok(actualizarRespuesta) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{respuestaId}")
    public ResponseEntity<Void> eliminarRespuesta(@PathVariable Long respuestaId) {
        respuestaService.eliminarRespuesta(respuestaId);
        return ResponseEntity.noContent().build();

    }


}
