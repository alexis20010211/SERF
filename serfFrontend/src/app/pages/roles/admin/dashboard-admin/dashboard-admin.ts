import { Component } from '@angular/core';
import { CommonModule, NgFor, NgIf } from '@angular/common';
import { Chart, registerables } from 'chart.js';

Chart.register(...registerables);

@Component({
  selector: 'app-dashboard-admin',
  standalone: true,
  imports: [CommonModule, NgIf, NgFor], // Standalone imports
  templateUrl: './dashboard-admin.html',
  styleUrls: ['./dashboard-admin.css']
})
export class DashboardAdmin {
  clientes = 45;
  tecnicos = 12;
  ventasTotales = 12500;

  ventas = [
    { producto: 'Laptop X', cantidad: 2, total: 2400 },
    { producto: 'Smartphone Y', cantidad: 3, total: 2400 },
    { producto: 'Accesorio Z', cantidad: 5, total: 250 },
  ];

  chart: Chart | undefined;

  ngAfterViewInit() {
    this.createChart();
  }

  createChart() {
    const ctx = document.getElementById('ventasChart') as HTMLCanvasElement | null;
    if (!ctx) return;

    this.chart = new Chart(ctx, {
      type: 'bar',
      data: {
        labels: this.ventas.map(v => v.producto),
        datasets: [
          {
            label: 'Total por producto',
            data: this.ventas.map(v => v.total),
            backgroundColor: ['#6c5ce7', '#00b894', '#fdcb6e'],
            borderRadius: 8
          }
        ]
      },
      options: {
        responsive: true,
        plugins: {
          legend: { display: false },
          tooltip: { enabled: true }
        },
        animation: { duration: 1000, easing: 'easeOutBounce' },
        scales: {
          y: { beginAtZero: true }
        }
      }
    });
  }
}
