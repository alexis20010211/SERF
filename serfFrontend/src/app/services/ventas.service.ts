import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpBaseService } from './http-base.service';

@Injectable({ providedIn: 'root' })
export class VentasService extends HttpBaseService {
  constructor(http: HttpClient) { super(http); }

  list() { return this.http.get<any[]>(`${this.api}/ventas`).toPromise(); }
  getResumen() { return this.http.get<any>(`${this.api}/ventas/resumen`).toPromise(); }
  create(payload:any) { return this.http.post<any>(`${this.api}/ventas`, payload).toPromise(); }
}
