import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Cliente {
  id: number;
  nombre: string;
  email?: string;
}

@Injectable({ providedIn: 'root' })
export class ClientesService {
  private api = 'http://localhost:3000/api'; // tu API

  constructor(private http: HttpClient) {}

  // Devuelve lista de clientes desde la API
  list(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(`${this.api}/clientes`);
  }

  // Opcional: obtener un cliente por ID
  getById(id: number): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.api}/clientes/${id}`);
  }
}
