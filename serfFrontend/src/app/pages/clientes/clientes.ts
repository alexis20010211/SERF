import { Component } from '@angular/core';
import { CommonModule, NgFor, NgIf } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { RouterModule, Router } from '@angular/router';

@Component({
  selector: 'app-clientes',
  standalone: true,
  imports: [CommonModule, NgFor, NgIf, ReactiveFormsModule, RouterModule],
  templateUrl: './clientes.html',
  styleUrls: ['./clientes.css']
})
export class Clientes {
  clienteForm: FormGroup;
  clientes: any[] = [];
  submitted = false;
  clienteRegistrado = false;
  accesoDenegado = false;

  constructor(
    private fb: FormBuilder,
    private auth: AuthService,
    private router: Router
  ) {
    this.clienteForm = this.fb.group({
      nombre: ['', Validators.required],
      correo: ['', [Validators.required, Validators.email]],
      telefono: ['', [Validators.required, Validators.pattern(/^[0-9]{7,15}$/)]]
    });

    // Verificar rol al inicializar
    const role = this.auth.getRole();
    if (role !== 'Administrador') {
      this.accesoDenegado = true;
    }
  }

  get f() { 
    return this.clienteForm.controls; 
  }

  onSubmit() {
    this.submitted = true;

    if (this.accesoDenegado) return;

    if (this.clienteForm.valid) {
      this.clientes.push(this.clienteForm.value);
      this.clienteForm.reset();
      this.submitted = false;
      this.clienteRegistrado = true;

      setTimeout(() => this.clienteRegistrado = false, 3000);
    }
  }
}
