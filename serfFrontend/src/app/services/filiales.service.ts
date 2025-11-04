// src/app/services/filiales.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Filial {
  id?: number;
  nombre: string;
  direccion: string;
  telefono?: string;
}

@Injectable({
  providedIn: 'root'
})
export class FilialesService {
  private api = 'http://localhost:3000/api'; // Ajusta la URL a tu backend

  constructor(private http: HttpClient) {}

  // Listar todas las filiales
  list(): Observable<Filial[]> {
    return this.http.get<Filial[]>(`${this.api}/filiales`);
  }

  // Obtener una filial por ID
  getById(id: number): Observable<Filial> {
    return this.http.get<Filial>(`${this.api}/filiales/${id}`);
  }

  // Crear una nueva filial
  create(filial: Filial): Observable<Filial> {
    return this.http.post<Filial>(`${this.api}/filiales`, filial);
  }

  // Actualizar una filial existente
  update(id: number, filial: Filial): Observable<Filial> {
    return this.http.put<Filial>(`${this.api}/filiales/${id}`, filial);
  }

  // Eliminar una filial
  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.api}/filiales/${id}`);
  }
}
