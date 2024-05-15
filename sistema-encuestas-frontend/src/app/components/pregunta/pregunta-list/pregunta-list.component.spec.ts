import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreguntaListComponent } from './pregunta-list.component';

describe('PreguntaListComponent', () => {
  let component: PreguntaListComponent;
  let fixture: ComponentFixture<PreguntaListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PreguntaListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PreguntaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
