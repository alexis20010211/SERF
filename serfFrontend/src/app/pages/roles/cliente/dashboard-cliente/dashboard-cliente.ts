import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgChartsModule } from 'ng2-charts';
import { ChartConfiguration } from 'chart.js';

@Component({
  selector: 'app-dashboard-cliente',
  standalone: true,
  imports: [CommonModule, NgChartsModule],
  template: `
    <h1 style="color:#0D47A1;">Dashboard Cliente</h1>

    <!-- Tarjetas resumen con animación -->
    <section class="stats-cards">
      <div class="card compras" (click)="toggleDetalle('compras')">
        <h3>Compras Realizadas</h3>
        <p>{{ resumen.compras }}</p>
        <small *ngIf="detalle=='compras'">Últimas compras detalladas...</small>
      </div>
      <div class="card solicitudes" (click)="toggleDetalle('solicitudes')">
        <h3>Solicitudes Abiertas</h3>
        <p>{{ resumen.solicitudesAbiertas }}</p>
        <small *ngIf="detalle=='solicitudes'">Solicitudes recientes enviadas...</small>
      </div>
      <div class="card productos" (click)="toggleDetalle('productos')">
        <h3>Productos Favoritos</h3>
        <p>{{ resumen.productosFavoritos }}</p>
        <small *ngIf="detalle=='productos'">Productos favoritos y seguimiento...</small>
      </div>
      <div class="card carrito" (click)="toggleDetalle('carrito')">
        <h3>Carrito</h3>
        <p>{{ carrito.length }} items</p>
        <small *ngIf="detalle=='carrito'">Productos en tu carrito listos para comprar...</small>
      </div>
    </section>

    <!-- Gráfico de compras por mes -->
    <section class="chart-section">
      <h2>Compras por Mes</h2>
      <canvas baseChart
        [data]="comprasData"
        [options]="comprasOptions"
        [type]="'bar'">
      </canvas>
    </section>

    <!-- Productos disponibles -->
    <section class="productos-recientes">
      <h2>Productos Disponibles</h2>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Producto</th>
            <th>Precio</th>
            <th>Estado</th>
            <th>Acción</th>
          </tr>
        </thead>
        <tbody>
          <tr *ngFor="let p of productos" [class.disponible]="p.estado==='Disponible'" [class.agotado]="p.estado==='Agotado'">
            <td>{{ p.id }}</td>
            <td>{{ p.nombre }}</td>
            <td>{{ p.precio | currency }}</td>
            <td>{{ p.estado }}</td>
            <td>
              <button (click)="agregarFavorito(p.id)" [disabled]="p.estado==='Agotado'">Favorito</button>
              <button (click)="agregarCarrito(p)" [disabled]="p.estado==='Agotado'">Agregar al Carrito</button>
            </td>
          </tr>
        </tbody>
      </table>
    </section>

    <!-- Carrito -->
    <section class="carrito-reciente" *ngIf="carrito.length > 0">
      <h2>Carrito de Compras</h2>
      <table>
        <thead>
          <tr>
            <th>Producto</th>
            <th>Precio</th>
            <th>Acción</th>
          </tr>
        </thead>
        <tbody>
          <tr *ngFor="let c of carrito">
            <td>{{ c.nombre }}</td>
            <td>{{ c.precio | currency }}</td>
            <td><button (click)="removerCarrito(c.id)">Eliminar</button></td>
          </tr>
        </tbody>
      </table>
      <p>Total: {{ totalCarrito() | currency }}</p>
    </section>

    <!-- Solicitudes del cliente -->
    <section class="solicitudes-recientes">
      <h2>Solicitudes Recientes</h2>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Tipo</th>
            <th>Descripción</th>
            <th>Estado</th>
            <th>Acción</th>
          </tr>
        </thead>
        <tbody>
          <tr *ngFor="let s of solicitudes" [class.pendiente]="s.estado==='Pendiente'" [class.en-proceso]="s.estado==='En proceso'" [class.completada]="s.estado==='Completada'">
            <td>{{ s.id }}</td>
            <td>{{ s.tipo }}</td>
            <td>{{ s.descripcion }}</td>
            <td>{{ s.estado }}</td>
            <td>
              <button (click)="cerrarSolicitud(s.id)" [disabled]="s.estado==='Completada'">Cerrar</button>
            </td>
          </tr>
        </tbody>
      </table>
    </section>
  `,
  styles: [`
    h1 { margin-bottom: 20px; }
    .stats-cards { display: flex; gap: 20px; margin-bottom: 30px; flex-wrap: wrap; }
    .card { flex: 1; min-width: 180px; background: #1976D2; color: #fff; padding: 20px; border-radius: 12px; cursor: pointer; transition: transform 0.3s, background 0.3s; }
    .card:hover { transform: translateY(-5px); background: #1565C0; }
    .card small { display: block; margin-top: 10px; font-size: 0.85em; color: #BBDEFB; }

    .chart-section { background: #fff; padding: 20px; border-radius: 12px; margin-bottom: 30px; box-shadow: 0 2px 6px rgba(0,0,0,0.1); }
    .chart-section h2 { color: #0D47A1; margin-bottom: 10px; }

    table { width: 100%; border-collapse: collapse; margin-bottom: 30px; }
    th, td { padding: 10px; border: 1px solid #ddd; text-align: left; }
    th { background: #1976D2; color: #fff; }
    tr.disponible { background: #BBDEFB; transition: background 0.3s; }
    tr.agotado { background: #E57373; color: #fff; transition: background 0.3s; }
    tr.pendiente { background: #BBDEFB; transition: background 0.3s; }
    tr.en-proceso { background: #64B5F6; transition: background 0.3s; }
    tr.completada { background: #0D47A1; color: #fff; transition: background 0.3s; }
    button { padding: 5px 10px; background: #0D47A1; color: #fff; border: none; border-radius: 5px; cursor: pointer; transition: transform 0.2s; margin-right: 5px; }
    button:hover { transform: scale(1.05); }
    button:disabled { background: #999; cursor: not-allowed; }
  `]
})
export class DashboardClienteComponent {
  detalle: string = '';

  resumen = {
    compras: 8,
    solicitudesAbiertas: 2,
    productosFavoritos: 5
  };

  comprasData: ChartConfiguration<'bar'>['data'] = {
    labels: ['Enero', 'Febrero', 'Marzo', 'Abril'],
    datasets: [
      { data: [2, 3, 1, 2], label: 'Compras', backgroundColor: '#1565C0' }
    ]
  };

  comprasOptions: ChartConfiguration<'bar'>['options'] = {
    responsive: true,
    scales: { y: { beginAtZero: true } }
  };

  productos = [
    { id: 1, nombre: 'Laptop HP', precio: 1200, estado: 'Disponible' },
    { id: 2, nombre: 'Smartphone Samsung', precio: 800, estado: 'Disponible' },
    { id: 3, nombre: 'Router Cisco', precio: 450, estado: 'Agotado' },
    { id: 4, nombre: 'Teclado Logitech', precio: 150, estado: 'Disponible' }
  ];

  solicitudes = [
    { id: 1, tipo: 'Soporte', descripcion: 'Problema con laptop', estado: 'Pendiente' },
    { id: 2, tipo: 'Devolución', descripcion: 'Cambio de smartphone', estado: 'En proceso' }
  ];

  carrito: any[] = [];

  toggleDetalle(tipo: string) { this.detalle = this.detalle===tipo ? '' : tipo; }
  agregarFavorito(id: number) { alert(`Producto ${id} agregado a favoritos`); }
  agregarCarrito(producto: any) { this.carrito.push(producto); }
  removerCarrito(id: number) { this.carrito = this.carrito.filter(p => p.id !== id); }
  totalCarrito() { return this.carrito.reduce((acc, item) => acc + item.precio, 0); }
  cerrarSolicitud(id: number) {
    const solicitud = this.solicitudes.find(s => s.id === id);
    if (solicitud) solicitud.estado = 'Completada';
  }
}
