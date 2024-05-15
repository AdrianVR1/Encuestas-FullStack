import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pregunta } from '../models/pregunta';

@Injectable({
  providedIn: 'root'
})
export class PreguntaService {
  private apiUrl = 'http://localhost:8090/api/preguntas';

  constructor(private http:HttpClient) { }

  agregarPreguntaAEncuesta(encuestaId:number,contenido:string):Observable<Pregunta>{
    return this.http.post<Pregunta>(`${this.apiUrl}/agregar/${encuestaId}`,{contenido});
  }

  obtenerPreguntaPorEncuesta(encuestaId:number):Observable<Pregunta[]>{
    return this.http.get<Pregunta[]>(`${this.apiUrl}/preguntaList/${encuestaId}`);
  }

  obtenerDetallesPregunta(preguntaId:number):Observable<Pregunta> {
    return this.http.get<Pregunta>(`${this.apiUrl}/${preguntaId}`);
  }

  actualizarPregunta(preguntaId:number, nuevoContenido:string, encuestaId:number):Observable<Pregunta> {
    return this.http.put<Pregunta>(`${this.apiUrl}/${preguntaId}/encuesta/${encuestaId}`,{preguntaId:preguntaId,contenido:nuevoContenido,encuestaId:encuestaId});
  }

  eliminarPregunta(preguntaId:number):Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${preguntaId}`);
  }

}
