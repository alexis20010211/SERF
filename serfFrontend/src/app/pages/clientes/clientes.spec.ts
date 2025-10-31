import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Clientes } from './clientes';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

describe('Clientes', () => {
  let component: Clientes;
  let fixture: ComponentFixture<Clientes>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Clientes] // Como es standalone, se importa directamente
    }).compileComponents();

    fixture = TestBed.createComponent(Clientes);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should register a new cliente', () => {
    component.clienteForm.setValue({
      nombre: 'Juan',
      correo: 'juan@example.com',
      telefono: '123456789'
    });
    component.onSubmit();
    expect(component.clientes.length).toBe(1);
    expect(component.clientes[0].nombre).toBe('Juan');
  });

  it('should not register cliente with invalid form', () => {
    component.clienteForm.setValue({
      nombre: '',
      correo: 'correo_invalido',
      telefono: ''
    });
    component.onSubmit();
    expect(component.clientes.length).toBe(0);
  });
});
