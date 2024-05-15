import { Component } from '@angular/core';
import { Pregunta } from '../../../models/pregunta';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { PreguntaService } from '../../../services/pregunta.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-pregunta-detail',
  standalone: true,
  imports: [NgIf, RouterLink],
  templateUrl: './pregunta-detail.component.html',
  styleUrl: './pregunta-detail.component.css'
})
export class PreguntaDetailComponent {

  pregunta:Pregunta | undefined;

  constructor(
    private route:ActivatedRoute,
    private preguntaService:PreguntaService
  ) {}

  ngOnInit():void{
    this.obtenerDetallesDeLaPregunta();
  }

  obtenerDetallesDeLaPregunta():void{
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.preguntaService.obtenerDetallesPregunta(id).subscribe(pregunta => {
      this.pregunta = pregunta;
    })
  }
}
