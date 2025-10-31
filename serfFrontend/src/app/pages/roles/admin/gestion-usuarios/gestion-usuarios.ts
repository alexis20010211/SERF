import { Component } from '@angular/core';
import { CommonModule, NgFor, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-usuarios',
  standalone: true,
  imports: [CommonModule, FormsModule, NgIf, NgFor],
  templateUrl: './gestion-usuarios.html',
  styleUrls: ['./gestion-usuarios.css']
})
export class Usuarios {
  usuarios = [
    { id: 1, nombre: 'Carlos', email: 'carlos@mail.com', rol: 'Admin' },
    { id: 2, nombre: 'Lucia', email: 'lucia@mail.com', rol: 'Filial' },
    { id: 3, nombre: 'Miguel', email: 'miguel@mail.com', rol: 'Filial' },
  ];

  nuevoUsuario = { nombre: '', email: '', rol: 'Filial' };
  submitted = false;

  agregarUsuario() {
    this.submitted = true;
    if(this.nuevoUsuario.nombre && this.nuevoUsuario.email) {
      const id = this.usuarios.length + 1;
      this.usuarios.push({...this.nuevoUsuario, id});
      this.nuevoUsuario = { nombre: '', email: '', rol: 'Filial' };
      this.submitted = false;
    }
  }
}
