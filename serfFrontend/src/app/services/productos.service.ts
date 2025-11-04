import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpBaseService } from './http-base.service';
import { Observable } from 'rxjs';
import { Producto } from '../shared/models/producto.model';

@Injectable({ providedIn: 'root' })
export class ProductosService extends HttpBaseService {
  constructor(http: HttpClient) {
    super(http);
  }

  list(): Observable<Producto[]> {
    return this.http.get<Producto[]>(`${this.api}/productos`);
  }

  getResumen(): Observable<any> {
    return this.http.get<any>(`${this.api}/productos/resumen`);
  }

  create(payload: Producto): Observable<Producto> {
    return this.http.post<Producto>(`${this.api}/productos`, payload);
  }
}
