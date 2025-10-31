import { Component } from '@angular/core';
import { CommonModule, NgFor, NgIf } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-tecnico',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, NgFor, NgIf],
  templateUrl: './tecnico.html',
  styleUrls: ['./tecnico.css']
})
export class Tecnico {
  tecnicoForm: FormGroup;
  submitted = false;
  tecnicosRegistrados: any[] = [];
  tecnicoRegistrado = false;

  constructor(private fb: FormBuilder) {
    this.tecnicoForm = this.fb.group({
      nombre: ['', Validators.required],
      especialidad: ['', Validators.required],
      telefono: ['', Validators.required]
    });
  }

  get f() {
    return this.tecnicoForm.controls;
  }

  registrarTecnico() {
    this.submitted = true;

    if (this.tecnicoForm.valid) {
      this.tecnicosRegistrados.push(this.tecnicoForm.value);
      this.tecnicoForm.reset();
      this.submitted = false;
      this.tecnicoRegistrado = true;

      // Ocultar mensaje después de 3 segundos
      setTimeout(() => this.tecnicoRegistrado = false, 3000);

      alert('Técnico registrado exitosamente!');
    }
  }
}
