import { Component } from '@angular/core';
import { CommonModule, NgFor } from '@angular/common';
import { NgChartsModule } from 'ng2-charts';
import { ChartOptions, ChartType, ChartData } from 'chart.js';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, NgChartsModule],
  templateUrl: './dashboard.html',
  styleUrls: ['./dashboard.css']
})
export class Dashboard {

  // Indicadores
  resumen = {
    ventasTotales: 12500,
    clientes: 18,
    tecnicos: 5,
    productosVendidos: 45
  };

  // Datos de ventas para gráficas
  ventasPorDia = {
    labels: ['Lunes','Martes','Miércoles','Jueves','Viernes','Sábado','Domingo'],
    datasets: [
      { data: [1200, 1500, 800, 2000, 1700, 900, 1500], label: 'Ventas Diarias', backgroundColor: '#4CAF50', borderColor: '#388E3C', fill: true }
    ]
  };

  productosMasVendidos = {
    labels: ['Laptop X','Smartphone Y','Accesorio Z'],
    datasets: [
      { data: [15, 20, 10], label: 'Productos vendidos', backgroundColor: ['#ff6384','#36a2eb','#ffce56'] }
    ]
  };

  ventasChartOptions: ChartOptions = {
    responsive: true,
    plugins: { legend: { display: true, position: 'bottom' } }
  };

  productosChartOptions: ChartOptions = {
    responsive: true,
    plugins: { legend: { display: true, position: 'bottom' } }
  };

  // Simular actualización de datos
  actualizarDatos() {
    // Aquí puedes reemplazar con llamadas a tu servicio real
    this.resumen.ventasTotales += Math.floor(Math.random()*1000);
    this.resumen.clientes += Math.floor(Math.random()*2);
    this.resumen.tecnicos += Math.floor(Math.random()*1);
    this.resumen.productosVendidos += Math.floor(Math.random()*5);
  }
}
