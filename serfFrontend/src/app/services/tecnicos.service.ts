// src/app/services/tecnicos.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Tecnico {
  id?: number;
  nombre: string;
  especialidad: string;
  telefono?: string;
}

@Injectable({
  providedIn: 'root'
})
export class TecnicosService {
  private api = 'http://localhost:3000/api'; // Ajusta la URL a tu backend

  constructor(private http: HttpClient) {}

  // Listar todos los técnicos
  list(): Observable<Tecnico[]> {
    return this.http.get<Tecnico[]>(`${this.api}/tecnicos`);
  }

  // Obtener un técnico por ID
  getById(id: number): Observable<Tecnico> {
    return this.http.get<Tecnico>(`${this.api}/tecnicos/${id}`);
  }

  // Crear un nuevo técnico
  create(tecnico: Tecnico): Observable<Tecnico> {
    return this.http.post<Tecnico>(`${this.api}/tecnicos`, tecnico);
  }

  // Actualizar un técnico existente
  update(id: number, tecnico: Tecnico): Observable<Tecnico> {
    return this.http.put<Tecnico>(`${this.api}/tecnicos/${id}`, tecnico);
  }

  // Eliminar un técnico
  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.api}/tecnicos/${id}`);
  }
}
