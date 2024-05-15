import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EncuestaDetailComponent } from './encuesta-detail.component';

describe('EncuestaDetailComponent', () => {
  let component: EncuestaDetailComponent;
  let fixture: ComponentFixture<EncuestaDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EncuestaDetailComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EncuestaDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
