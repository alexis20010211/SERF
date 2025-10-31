import { Component, AfterViewInit, ViewChild, ElementRef } from '@angular/core';
import { CommonModule, NgIf, NgFor } from '@angular/common';
import { AuthService } from '../../services/auth.service';
import Chart from 'chart.js/auto';

@Component({
  selector: 'app-reportes',
  standalone: true,
  imports: [CommonModule, NgIf, NgFor],
  templateUrl: './reportes.html',
  styleUrls: ['./reportes.css']
})
export class Reportes implements AfterViewInit {
  resumen = {
    ventasTotales: 0,
    productosVendidos: 0,
    clientesAtendidos: 0
  };

  ventas: any[] = [];
  mostrarReporte = false;
  animarTotal = false;

  @ViewChild('ventasChart') ventasChart!: ElementRef<HTMLCanvasElement>;

  constructor(private auth: AuthService) {}

  generarReporte() {
    this.mostrarReporte = true;
    this.animarTotal = false;

    // Configurar datos según rol
    this.loadDatosPorRol();

    setTimeout(() => {
      this.animarTotal = true;
      this.renderChart();
    }, 100);
  }

  ngAfterViewInit() {
    if (this.mostrarReporte) {
      this.renderChart();
    }
  }

  private loadDatosPorRol() {
    const role = this.auth.getRole();

    if (role === 'Administrador') {
      this.ventas = [
        { factura: 'F001', fecha: '2025-10-30', producto: 'Laptop X', cantidad: 2, total: 2400 },
        { factura: 'F002', fecha: '2025-10-29', producto: 'Smartphone Y', cantidad: 3, total: 2400 },
        { factura: 'F003', fecha: '2025-10-28', producto: 'Accesorio Z', cantidad: 5, total: 250 },
      ];
      this.resumen = {
        ventasTotales: this.ventas.reduce((acc, v) => acc + v.total, 0),
        productosVendidos: this.ventas.reduce((acc, v) => acc + v.cantidad, 0),
        clientesAtendidos: 18 // puede venir de un servicio real
      };
    } else if (role === 'Filial') {
      this.ventas = [
        { factura: 'F101', fecha: '2025-10-30', producto: 'Laptop X', cantidad: 1, total: 1200 },
        { factura: 'F102', fecha: '2025-10-29', producto: 'Smartphone Y', cantidad: 2, total: 1600 },
      ];
      this.resumen = {
        ventasTotales: this.ventas.reduce((acc, v) => acc + v.total, 0),
        productosVendidos: this.ventas.reduce((acc, v) => acc + v.cantidad, 0),
        clientesAtendidos: 8
      };
    }
  }

  private renderChart() {
    const ctx = this.ventasChart.nativeElement.getContext('2d');
    if (ctx) {
      new Chart(ctx, {
        type: 'bar',
        data: {
          labels: this.ventas.map(v => v.producto),
          datasets: [{
            label: 'Total por Producto',
            data: this.ventas.map(v => v.total),
            backgroundColor: ['#004aad', '#1e90ff', '#6cace4'],
            borderRadius: 6
          }]
        },
        options: {
          responsive: true,
          animation: { duration: 1200, easing: 'easeOutBounce' },
          plugins: {
            legend: { display: true, position: 'top' },
            title: { display: true, text: 'Ventas Recientes', font: { size: 20 } }
          }
        }
      });
    }
  }
}
