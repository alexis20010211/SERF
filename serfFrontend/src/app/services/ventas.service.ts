// src/app/services/ventas.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpBaseService } from './http-base.service';
import { Observable } from 'rxjs';
import { VentaDTO } from '../dto/venta.dto';

@Injectable({ providedIn: 'root' })
export class VentasService extends HttpBaseService {
  constructor(http: HttpClient) {
    super(http);
  }

  /**
   * Listar todas las ventas
   * @returns Observable con array de ventas
   */
  list(): Observable<VentaDTO[]> {
    return this.http.get<VentaDTO[]>(`${this.api}/ventas`);
  }

  /**
   * Obtener resumen de ventas
   * @returns Observable con resumen de ventas
   */
  getResumen(): Observable<any> {
    return this.http.get<any>(`${this.api}/ventas/resumen`);
  }

  /**
   * Crear una nueva venta
   * @param payload VentaDTO
   * @returns Observable con la venta creada
   */
  create(payload: VentaDTO): Observable<VentaDTO> {
    return this.http.post<VentaDTO>(`${this.api}/ventas`, payload);
  }
}
