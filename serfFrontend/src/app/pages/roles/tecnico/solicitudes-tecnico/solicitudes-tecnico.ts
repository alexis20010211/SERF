import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-solicitudes-tecnico',
  standalone: true,
  imports: [CommonModule],
  template: `
    <h1>Solicitudes Asignadas</h1>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Cliente</th>
          <th>Descripción</th>
          <th>Estado</th>
          <th>Acciones</th>
        </tr>
      </thead>
      <tbody>
        <tr *ngFor="let s of solicitudes">
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
  `,
  styles: [`
    table { width: 100%; border-collapse: collapse; background: #fff; margin-top: 20px; }
    th, td { padding: 10px; border: 1px solid #ddd; text-align: left; }
    th { background: #1976D2; color: #fff; }
    button { padding: 5px 10px; background: #0D47A1; color: #fff; border: none; border-radius: 5px; cursor: pointer; }
    button:disabled { background: #999; cursor: not-allowed; }
  `]
})
export class SolicitudesTecnicoPage {
  solicitudes = [
    { id: 1, cliente: 'Juan Pérez', descripcion: 'Instalación de red', estado: 'Pendiente' },
    { id: 2, cliente: 'María López', descripcion: 'Reparación de laptop', estado: 'En proceso' },
    { id: 3, cliente: 'Carlos Ruiz', descripcion: 'Mantenimiento de servidor', estado: 'Pendiente' }
  ];

  marcarCompletada(id: number) {
    const solicitud = this.solicitudes.find(s => s.id === id);
    if (solicitud) solicitud.estado = 'Completada';
  }
}
