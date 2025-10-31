import { Component } from '@angular/core';
import { CommonModule, NgFor, NgIf } from '@angular/common';
import { NgChartsModule } from 'ng2-charts';
import { ChartData, ChartOptions } from 'chart.js';

@Component({
  selector: 'app-reportes-admin',
  standalone: true,
  imports: [CommonModule, NgIf, NgFor, NgChartsModule],
  templateUrl: './reportes-admin.html',
  styleUrls: ['./reportes-admin.css']
})
export class ReportesAdmin {
  mostrarReporte = false;

  resumen = {
    ventasTotales: 12500,
    productosVendidos: 45,
    clientesAtendidos: 18
  };

  ventas = [
    { factura: 'F001', fecha: '2025-10-30', producto: 'Laptop X', cantidad: 2, total: 2400 },
    { factura: 'F002', fecha: '2025-10-29', producto: 'Smartphone Y', cantidad: 3, total: 2400 },
    { factura: 'F003', fecha: '2025-10-28', producto: 'Accesorio Z', cantidad: 5, total: 250 },
  ];

  // Datos para gráfico de ventas
  ventasData: ChartData<'bar'> = {
    labels: this.ventas.map(v => v.producto),
    datasets: [
      { label: 'Cantidad vendida', data: this.ventas.map(v => v.cantidad), backgroundColor: '#4f46e5' },
      { label: 'Total ventas', data: this.ventas.map(v => v.total), backgroundColor: '#3b82f6' }
    ]
  };

  ventasOptions: ChartOptions<'bar'> = {
    responsive: true,
    plugins: {
      legend: { position: 'top' }
    }
  };

  generarReporte() {
    this.mostrarReporte = true;
  }
}
