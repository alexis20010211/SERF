// usuarios.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Usuario {
  id: number;
  nombre: string;
  role: 'Cliente' | 'Tecnico' | 'Admin';
}

@Injectable({ providedIn: 'root' })
export class UsuariosService {
  private api = 'http://localhost:3000/api';

  constructor(private http: HttpClient) {}

  list(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`${this.api}/usuarios`);
  }
}
