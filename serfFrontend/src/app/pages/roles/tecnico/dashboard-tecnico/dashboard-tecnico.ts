import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgChartsModule } from 'ng2-charts';
import { ChartConfiguration } from 'chart.js';

@Component({
  selector: 'app-dashboard-tecnico',
  standalone: true,
  imports: [CommonModule, NgChartsModule],
  template: `
    <h1 style="color:#0D47A1;">Dashboard Técnico</h1>

    <!-- Tarjetas resumen -->
    <section class="stats-cards">
      <div class="card solicitudes" (click)="toggleDetalle('asignadas')">
        <h3>Solicitudes Asignadas</h3>
        <p>{{ resumen.solicitudesAsignadas }}</p>
        <small *ngIf="detalle=='asignadas'">Detalle de solicitudes asignadas...</small>
      </div>
      <div class="card completadas" (click)="toggleDetalle('completadas')">
        <h3>Solicitudes Completadas</h3>
        <p>{{ resumen.solicitudesCompletadas }}</p>
        <small *ngIf="detalle=='completadas'">Detalle de solicitudes completadas...</small>
      </div>
      <div class="card clientes" (click)="toggleDetalle('clientes')">
        <h3>Clientes Atendidos</h3>
        <p>{{ resumen.clientesAtendidos }}</p>
        <small *ngIf="detalle=='clientes'">Detalle de clientes atendidos...</small>
      </div>
    </section>

    <!-- Gráfico de solicitudes -->
    <section class="chart-section">
      <h2>Solicitudes por Mes</h2>
      <canvas baseChart
        [data]="solicitudesData"
        [options]="solicitudesOptions"
        [type]="'bar'">
      </canvas>
    </section>

    <!-- Lista simulada de solicitudes recientes -->
    <section class="solicitudes-recientes">
      <h2>Solicitudes Recientes</h2>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Cliente</th>
            <th>Descripción</th>
            <th>Estado</th>
            <th>Acción</th>
          </tr>
        </thead>
        <tbody>
          <tr *ngFor="let s of solicitudes" [class.pendiente]="s.estado==='Pendiente'" [class.proceso]="s.estado==='En proceso'" [class.completada]="s.estado==='Completada'">
            <td>{{ s.id }}</td>
            <td>{{ s.cliente }}</td>
            <td>{{ s.descripcion }}</td>
            <td>{{ s.estado }}</td>
            <td>
              <button (click)="marcarCompletada(s.id)" [disabled]="s.estado==='Completada'">Completar</button>
            </td>
          </tr>
        </tbody>
      </table>
    </section>
  `,
  styles: [`
    h1 { margin-bottom: 20px; }
    .stats-cards { display: flex; gap: 20px; margin-bottom: 30px; }
    .card { flex: 1; background: #1976D2; color: #fff; padding: 20px; border-radius: 10px; box-shadow: 0 2px 6px rgba(0,0,0,0.2); cursor: pointer; transition: transform 0.3s, background 0.3s; }
    .card:hover { transform: translateY(-5px); background: #1565C0; }
    .card small { display: block; margin-top: 10px; font-size: 0.85em; color: #BBDEFB; }

    .chart-section { background: #fff; padding: 20px; border-radius: 10px; margin-bottom: 30px; }
    .chart-section h2 { color: #0D47A1; margin-bottom: 10px; }

    .solicitudes-recientes { background: #fff; padding: 20px; border-radius: 10px; }
    .solicitudes-recientes h2 { color: #0D47A1; margin-bottom: 10px; }
    table { width: 100%; border-collapse: collapse; }
    th, td { padding: 10px; border: 1px solid #ddd; text-align: left; }
    th { background: #1976D2; color: #fff; }
    tr.pendiente { background: #BBDEFB; transition: background 0.3s; }
    tr.proceso { background: #64B5F6; transition: background 0.3s; }
    tr.completada { background: #0D47A1; color: #fff; transition: background 0.3s; }
    button { padding: 5px 10px; background: #0D47A1; color: #fff; border: none; border-radius: 5px; cursor: pointer; transition: transform 0.2s; }
    button:hover { transform: scale(1.05); }
    button:disabled { background: #999; cursor: not-allowed; }
  `]
})
export class DashboardTecnicoComponent {
  detalle: string = '';

  resumen = {
    solicitudesAsignadas: 15,
    solicitudesCompletadas: 7,
    clientesAtendidos: 12
  };

  solicitudesData: ChartConfiguration<'bar'>['data'] = {
    labels: ['Enero', 'Febrero', 'Marzo', 'Abril'],
    datasets: [
      { data: [5, 7, 3, 8], label: 'Solicitudes', backgroundColor: '#1565C0' }
    ]
  };

  solicitudesOptions: ChartConfiguration<'bar'>['options'] = {
    responsive: true,
    scales: { y: { beginAtZero: true } }
  };

  solicitudes = [
    { id: 1, cliente: 'Juan Pérez', descripcion: 'Instalación de red', estado: 'Pendiente' },
    { id: 2, cliente: 'María López', descripcion: 'Reparación de laptop', estado: 'En proceso' },
    { id: 3, cliente: 'Carlos Ruiz', descripcion: 'Mantenimiento de servidor', estado: 'Pendiente' },
    { id: 4, cliente: 'Ana Torres', descripcion: 'Actualización de software', estado: 'Completada' }
  ];

  toggleDetalle(tipo: string) {
    this.detalle = this.detalle === tipo ? '' : tipo;
  }

  marcarCompletada(id: number) {
    const solicitud = this.solicitudes.find(s => s.id === id);
    if (solicitud) solicitud.estado = 'Completada';
  }
}
