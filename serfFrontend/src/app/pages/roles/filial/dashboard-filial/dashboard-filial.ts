import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgChartsModule } from 'ng2-charts'; // CORRECTO

@Component({
  selector: 'app-dashboard-filial',
  standalone: true,
  imports: [CommonModule, NgChartsModule], // usar NgChartsModule aquí
  templateUrl: './dashboard-filial.html',
  styleUrls: ['./dashboard-filial.css']
})
export class DashboardFilial {
  mostrarDashboard = false;

  resumen = {
    ventasTotales: 0,
    productosVendidos: 0,
    clientesAtendidos: 0
  };

  ventasData = {
    labels: ['Enero', 'Febrero', 'Marzo'],
    datasets: [
      { data: [0, 0, 0], label: 'Ventas' }
    ]
  };

  ventasOptions = {
    responsive: true,
    scales: { y: { beginAtZero: true } }
  };

  generarDashboard() {
    // Datos simulados, reemplazar por datos reales desde un servicio
    this.resumen = {
      ventasTotales: 12500,
      productosVendidos: 320,
      clientesAtendidos: 75
    };

    this.ventasData = {
      labels: ['Enero', 'Febrero', 'Marzo'],
      datasets: [
        { data: [5000, 4000, 3500], label: 'Ventas' }
      ]
    };

    this.mostrarDashboard = true;
  }
}
