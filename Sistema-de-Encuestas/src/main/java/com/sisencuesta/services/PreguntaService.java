package com.sisencuesta.services;

import com.sisencuesta.models.Pregunta;

import java.util.List;
import java.util.Optional;

public interface PreguntaService {
    Pregunta agregarPreguntaAEncuesta(Long encuestaId, String contenido);
    List<Pregunta>obtenerPreguntaPorEncuesta(Long encuestaId);
    Optional<Pregunta>obtenerDetallesPregunta(Long preguntaId);
    Pregunta actualizarPregunta(Long preguntaId, String nuevoContenido, Long encuestaId);
    void eliminarPregunta(Long preguntaId);
}
