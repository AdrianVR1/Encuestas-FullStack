import { Component } from '@angular/core';
import { Encuesta } from '../../../models/encuesta';
import { ActivatedRoute } from '@angular/router';
import { EncuestaService } from '../../../services/encuesta.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-encuesta-detail',
  standalone: true,
  imports: [NgIf],
  templateUrl: './encuesta-detail.component.html',
  styleUrl: './encuesta-detail.component.css'
})
export class EncuestaDetailComponent {

  encuesta:Encuesta | undefined;

  constructor(
    private route:ActivatedRoute, 
    private encuestaService:EncuestaService) {
  }

  ngOnInit():void {
    this.obtenerDetallesDeLaEncuesta();
  }

  obtenerDetallesDeLaEncuesta():void{
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.encuestaService.obtenerDetallesEncuesta(id).subscribe(encuesta => {
      this.encuesta = encuesta;
    })
    
  }

}
