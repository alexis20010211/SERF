// src/app/services/usuarios.service.ts
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Usuario } from '../shared/models/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  // Datos de ejemplo para pruebas
  private usuarios: Usuario[] = [
    { id: 1, nombre: 'Juan Perez', email: 'juan@mail.com', role: 'Cliente' },
    { id: 2, nombre: 'Ana Gomez', email: 'ana@mail.com', role: 'Tecnico' }
  ];

  constructor() { }

  // Método para listar usuarios (simula una llamada HTTP)
  list(): Observable<Usuario[]> {
    return of(this.usuarios);
  }

  // Método para obtener un usuario por ID (opcional)
  getById(id: number): Observable<Usuario | undefined> {
    const usuario = this.usuarios.find(u => u.id === id);
    return of(usuario);
  }
}
