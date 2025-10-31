import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Tecnico } from './tecnico';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

describe('Tecnico', () => {
  let component: Tecnico;
  let fixture: ComponentFixture<Tecnico>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Tecnico, CommonModule, FormsModule, ReactiveFormsModule]
    }).compileComponents();

    fixture = TestBed.createComponent(Tecnico);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
