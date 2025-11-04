import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgChartsModule } from 'ng2-charts';
import { ChartConfiguration } from 'chart.js';

@Component({
  selector: 'app-dashboard-admin',
  standalone: true,
  imports: [CommonModule, NgChartsModule],
  template: `
    <h1 style="color:#0D47A1;">Dashboard Administrador</h1>

    <!-- Tarjetas resumen con animación -->
    <div class="stats-cards">
      <div class="card ventas">
        <h3>Total Ventas</h3>
        <p>{{resumen.ventasTotales | currency}}</p>
        <button class="btn-imprimir" (click)="imprimir('ventas')">🖨 Imprimir</button>
      </div>
      <div class="card clientes">
        <h3>Total Clientes</h3>
        <p>{{resumen.clientesAtendidos}}</p>
        <button class="btn-imprimir" (click)="imprimir('clientes')">🖨 Imprimir</button>
      </div>
      <div class="card productos">
        <h3>Productos</h3>
        <p>{{resumen.productosVendidos}}</p>
        <button class="btn-imprimir" (click)="imprimir('productos')">🖨 Imprimir</button>
      </div>
      <div class="card tecnicos">
        <h3>Técnicos</h3>
        <p>{{resumen.tecnicosRegistrados}}</p>
        <button class="btn-imprimir" (click)="imprimir('tecnicos')">🖨 Imprimir</button>
      </div>
    </div>

    <!-- Gráfico Ventas por Mes -->
    <div class="chart-card">
      <canvas baseChart
              [data]="ventasData"
              [options]="ventasOptions"
              [type]="'bar'">
      </canvas>
    </div>

    <!-- Historial de Ventas -->
    <section class="tabla-ventas">
      <h2>Historial de Ventas</h2>
      <table>
        <thead>
          <tr><th>ID</th><th>Cliente</th><th>Producto</th><th>Monto</th><th>Fecha</th><th>Acciones</th></tr>
        </thead>
        <tbody>
          <tr *ngFor="let v of ventas">
            <td>{{v.id}}</td>
            <td>{{v.cliente}}</td>
            <td>{{v.producto}}</td>
            <td>{{v.monto | currency}}</td>
            <td>{{v.fecha | date:'short'}}</td>
            <td>
              <button (click)="imprimirVenta(v)">🖨 Imprimir Boleta</button>
              <button (click)="generarFactura(v)">💰 Generar Factura</button>
            </td>
          </tr>
        </tbody>
      </table>
    </section>
  `,
  styles: [`
    .stats-cards { display:flex; gap:15px; margin-bottom:25px; flex-wrap:wrap; }
    .card { flex:1; min-width:180px; padding:20px; color:#fff; border-radius:12px; text-align:center; transition: transform 0.3s; position:relative; }
    .card:hover { transform: scale(1.05); }
    .ventas { background-color:#1976D2; }
    .clientes { background-color:#1565C0; }
    .productos { background-color:#42A5F5; }
    .tecnicos { background-color:#64B5F6; }
    .btn-imprimir { margin-top:10px; padding:5px 10px; background:#0D47A1; border:none; color:#fff; border-radius:6px; cursor:pointer; transition:0.2s; }
    .btn-imprimir:hover { transform:scale(1.1); background:#1565C0; }

    .chart-card { background:#fff; padding:20px; border-radius:12px; box-shadow:0 2px 10px rgba(0,0,0,0.2); margin-bottom:20px; }
    .tabla-ventas table { width:100%; border-collapse:collapse; background:#fff; border-radius:10px; overflow:hidden; }
    .tabla-ventas th, .tabla-ventas td { padding:10px; border:1px solid #ddd; text-align:left; }
    .tabla-ventas th { background:#1976D2; color:#fff; }
    .tabla-ventas tr:hover { background:#BBDEFB; transition:0.3s; }
    button { margin-right:5px; }
  `]
})
export class DashboardAdmin {
  resumen = { ventasTotales: 45000, productosVendidos: 320, clientesAtendidos: 120, tecnicosRegistrados: 15 };

  ventasData = { labels:['Enero','Febrero','Marzo'], datasets:[{ data:[15000,18000,12000], label:'Ventas', backgroundColor:'#1565C0' }] };
  ventasOptions = { responsive:true, scales:{y:{beginAtZero:true}} };

  ventas = [
    { id:1, cliente:'Juan Pérez', producto:'Laptop HP', monto:1200, fecha:new Date() },
    { id:2, cliente:'María López', producto:'Smartphone Samsung', monto:800, fecha:new Date() },
    { id:3, cliente:'Carlos Ruiz', producto:'Router Cisco', monto:450, fecha:new Date() },
    { id:4, cliente:'Ana Torres', producto:'Teclado Logitech', monto:150, fecha:new Date() }
  ];

  imprimir(tipo: string) {
    alert(`Imprimiendo reporte de ${tipo}`);
    // Aquí puedes usar window.print() o generar PDF con jsPDF
  }

  imprimirVenta(venta: any) {
    alert(`Imprimiendo boleta de la venta ID: ${venta.id}`);
  }

  generarFactura(venta: any) {
    alert(`Generando factura para la venta ID: ${venta.id}`);
  }
}
