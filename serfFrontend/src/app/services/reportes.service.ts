import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReportesService {

  constructor() {}

  /** Simula la generación de un reporte mensual */
  async generarReporteMensual(): Promise<any> {
    // Aquí podrías hacer una petición HTTP real
    return new Promise(resolve => {
      setTimeout(() => {
        resolve({
          id: Date.now(),
          fecha: new Date().toLocaleDateString(),
          ventasTotales: 12500,
          productosVendidos: 340,
          ganancias: 6800
        });
      }, 1000);
    });
  }
}
