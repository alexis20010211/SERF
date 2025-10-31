import { Injectable } from '@angular/core';
import { ReportesService } from '../../services/reportes.service';

/**
 * 🔹 ReportFacade
 * Fachada que centraliza la lógica de generación y manejo de reportes.
 * Forma parte del módulo o patrón "report-patterns".
 */
@Injectable({
  providedIn: 'root'
})
export class ReportFacade {
  private _ultimoReporte: Record<string, any> | null = null;

  constructor(private readonly reportesService: ReportesService) {}

  /** 🧾 Genera un reporte mensual usando el servicio de reportes */
  async generarMensual(): Promise<Record<string, any> | null> {
    try {
      const reporte = await this.reportesService.generarReporteMensual();
      this._ultimoReporte = reporte;
      return reporte;
    } catch (error) {
      console.error('❌ Error al generar el reporte mensual:', error);
      return null;
    }
  }

  /** 📦 Obtiene el último reporte generado */
  get ultimoReporte(): Record<string, any> | null {
    return this._ultimoReporte;
  }

  /** 🧹 Limpia el último reporte almacenado */
  limpiarReporte(): void {
    this._ultimoReporte = null;
  }
}
