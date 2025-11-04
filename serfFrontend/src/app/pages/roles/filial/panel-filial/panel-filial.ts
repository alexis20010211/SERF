// src/app/pages/roles/filial/panel-filial/panel-filial.ts
import { Component } from '@angular/core';
import { RouterOutlet, Router } from '@angular/router';
import { CommonModule, NgFor } from '@angular/common';
import { AuthService } from '../../../../services/auth.service';

@Component({
  selector: 'app-panel-filial',
  standalone: true,
  imports: [CommonModule, NgFor, RouterOutlet],
  template: `
  <div class="filial-container">
    <!-- Sidebar -->
    <aside class="sidebar">
      <div class="brand">
        <div class="brand-logo">FINANCORP</div>
        <div class="brand-sub">Filial</div>
      </div>

      <div class="user-info" *ngIf="rol">
        <p>{{ auth.getEmail() }}</p>
        <small>{{ rol }}</small>
      </div>

      <nav class="nav">
        <ul>
          <li *ngFor="let m of modulos"
              [class.active]="isActive(m.ruta)"
              (click)="navegarModulo(m.ruta)">
            {{ m.nombre }}
          </li>
        </ul>
      </nav>

      <button class="btn-logout" (click)="logout()">Cerrar sesión</button>
    </aside>

    <!-- Main content -->
    <main class="main-content">
      <router-outlet></router-outlet>

      <!-- Dashboard Filial -->
      <section class="dashboard" *ngIf="isActive('dashboard')">
        <h1>Dashboard Filial</h1>

        <div class="stats-cards">
          <div class="card">
            <h3>Ventas Totales</h3>
            <p>{{ totalVentas | currency }}</p>
          </div>
          <div class="card">
            <h3>Productos Vendidos</h3>
            <p>{{ totalProductos }}</p>
          </div>
          <div class="card">
            <h3>Clientes Atendidos</h3>
            <p>{{ totalClientes }}</p>
          </div>
        </div>

        <section class="tables">
          <h2>Ventas Mensuales</h2>
          <table>
            <thead>
              <tr>
                <th>Mes</th>
                <th>Ventas</th>
              </tr>
            </thead>
            <tbody>
              <tr *ngFor="let v of ventasMensuales">
                <td>{{ v.mes }}</td>
                <td>{{ v.monto | currency }}</td>
              </tr>
            </tbody>
          </table>
        </section>
      </section>
    </main>
  </div>
  `,
  styles: [`
    .filial-container { display: flex; height: 100vh; font-family: Arial, sans-serif; }
    .sidebar { width: 220px; background: #0D47A1; color: #fff; display: flex; flex-direction: column; justify-content: space-between; }
    .brand { padding: 20px; text-align: center; }
    .brand-logo { font-size: 1.5em; font-weight: bold; }
    .brand-sub { font-size: 0.9em; margin-top: 5px; }
    .user-info { padding: 10px 20px; border-top: 1px solid rgba(255,255,255,0.2); border-bottom: 1px solid rgba(255,255,255,0.2); margin-bottom: 10px; }
    .user-info p { margin: 0; font-weight: bold; }
    .user-info small { font-size: 0.8em; color: rgba(255,255,255,0.7); }
    .nav ul { list-style: none; padding: 0; margin: 0; }
    .nav li { padding: 15px 20px; cursor: pointer; transition: 0.3s; }
    .nav li:hover, .nav li.active { background: #1565C0; }
    .btn-logout { margin: 20px; padding: 10px; background: #D32F2F; color: #fff; border: none; cursor: pointer; }
    .main-content { flex: 1; padding: 20px; background: #f5f5f5; overflow-y: auto; }

    .dashboard h1 { margin-bottom: 20px; color: #0D47A1; }
    .stats-cards { display: flex; gap: 20px; margin-bottom: 30px; }
    .card { flex: 1; background: #1976D2; color: #fff; padding: 20px; border-radius: 10px; text-align: center; box-shadow: 0 2px 6px rgba(0,0,0,0.2); }
    .card h3 { margin: 0 0 10px; }
    .tables table { width: 100%; border-collapse: collapse; background: #fff; }
    .tables th, .tables td { padding: 10px; border: 1px solid #ddd; text-align: left; }
    .tables th { background: #1976D2; color: #fff; }
  `]
})
export class PanelFilial {
  modulos = [
    { nombre: 'Dashboard', ruta: 'dashboard' },
    { nombre: 'Clientes', ruta: 'clientes' },
    { nombre: 'Ventas', ruta: 'ventas' },
    { nombre: 'Reportes', ruta: 'reportes' },
  ];

  totalVentas = 12500;
  totalProductos = 320;
  totalClientes = 75;

  ventasMensuales = [
    { mes: 'Enero', monto: 1500 },
    { mes: 'Febrero', monto: 1200 },
    { mes: 'Marzo', monto: 1800 },
    { mes: 'Abril', monto: 1000 },
    { mes: 'Mayo', monto: 1500 },
    { mes: 'Junio', monto: 2500 },
  ];

  constructor(public auth: AuthService, private router: Router) {}

  navegarModulo(ruta: string) {
    this.router.navigate(['/filial', ruta]);
  }

  logout() {
    this.auth.logout();
    this.router.navigate(['']);
  }

  isActive(ruta: string): boolean {
    return this.router.url.includes(ruta);
  }

  get rol(): string | null {
    return this.auth.getRole();
  }
}
