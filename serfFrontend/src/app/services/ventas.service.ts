import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpBaseService } from './http-base.service';
import { VentaDTO } from '../dto/venta.dto';

// Opcional: puedes crear un DTO para el resumen de ventas
// import { ResumenVentasDTO } from '../dto/resumen-ventas.dto';

@Injectable({ providedIn: 'root' })
export class VentasService extends HttpBaseService {
  constructor(http: HttpClient) { super(http); }

  /**
   * Listar todas las ventas
   * @returns Promise<VentaDTO[]> siempre devuelve un array, aunque la respuesta sea vacía
   */
  list(): Promise<VentaDTO[]> {
    return this.http.get<VentaDTO[]>(`${this.api}/ventas`)
      .toPromise()
      .then(res => res || []); // evita undefined
  }

  /**
   * Obtener resumen de ventas
   * @returns Promise<any> o puedes usar un DTO
   */
  getResumen(): Promise<any> {
    return this.http.get<any>(`${this.api}/ventas/resumen`)
      .toPromise()
      .then(res => res || {}); // devuelve un objeto vacío si es undefined
  }

  /**
   * Crear una nueva venta
   * @param payload VentaDTO
   * @returns Promise<VentaDTO>
   */
  create(payload: VentaDTO): Promise<VentaDTO> {
    return this.http.post<VentaDTO>(`${this.api}/ventas`, payload)
      .toPromise()
      .then(res => res!); // asegura que no sea undefined
  }
}
