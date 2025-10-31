import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpBaseService } from './http-base.service';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class ProductosService extends HttpBaseService {
  constructor(http: HttpClient) {
    super(http);
  }

  /**
   * Obtener lista completa de productos
   * @returns Observable con array de productos
   */
  list(): Observable<any[]> {
    return this.http.get<any[]>(`${this.api}/productos`);
  }

  /**
   * Obtener resumen general de productos
   * (por ejemplo totales, categorías, etc.)
   * @returns Observable con resumen
   */
  getResumen(): Observable<any> {
    return this.http.get<any>(`${this.api}/productos/resumen`);
  }

  /**
   * Registrar un nuevo producto en el backend
   * @param payload objeto con datos del producto
   * @returns Observable con la respuesta del backend
   */
  create(payload: any): Observable<any> {
    return this.http.post<any>(`${this.api}/productos`, payload);
  }
}
