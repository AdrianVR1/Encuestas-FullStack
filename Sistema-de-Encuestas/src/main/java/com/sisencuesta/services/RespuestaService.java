package com.sisencuesta.services;

import com.sisencuesta.models.Respuesta;

import java.util.List;
import java.util.Optional;

public interface RespuestaService {

    Respuesta agregarRespuestaAPregunta(Long preguntaId, String contenido);
    List<Respuesta>obtenerRespuestaPorPregunta(Long preguntaId);
    Optional<Respuesta>obtenerDetallesRespuesta(Long respuestaId);
    Respuesta actualizarRespuesta(Long respuestaId, String nuevoContenido);
    void eliminarRespuesta(Long respuestaId);
}
