import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Router, RouterOutlet } from '@angular/router';
import { AuthService } from '../../../../services/auth.service';
import { NgChartsModule } from 'ng2-charts';

@Component({
  selector: 'app-panel-tecnico',
  standalone: true,
  imports: [CommonModule, RouterModule, RouterOutlet, NgChartsModule],
  template: `
  <div class="panel-container">
    <!-- Sidebar -->
    <aside class="sidebar">
      <div class="brand">
        <div class="brand-logo">FINANCORP</div>
        <div class="brand-sub">Técnico</div>
      </div>
      <nav class="nav">
        <ul>
          <li [class.active]="isActive('dashboard')" (click)="navegarModulo('dashboard')">Dashboard</li>
          <li [class.active]="isActive('solicitudes')" (click)="navegarModulo('solicitudes')">Solicitudes</li>
          <li [class.active]="isActive('panel-tecnico')" (click)="navegarModulo('panel-tecnico')">Panel Técnico</li>
        </ul>
      </nav>
      <button class="btn-logout" (click)="logout()">Cerrar sesión</button>
    </aside>

    <!-- Main content -->
    <main class="main-content">
      <router-outlet></router-outlet>
    </main>
  </div>
  `,
  styles: [`
    .panel-container { display: flex; height: 100vh; font-family: Arial, sans-serif; }
    .sidebar { width: 220px; background: #0D47A1; color: #fff; display: flex; flex-direction: column; justify-content: space-between; }
    .brand { padding: 20px; text-align: center; }
    .brand-logo { font-size: 1.5em; font-weight: bold; }
    .brand-sub { font-size: 0.9em; margin-top: 5px; }
    .nav ul { list-style: none; padding: 0; margin: 0; }
    .nav li { padding: 15px 20px; cursor: pointer; transition: 0.3s; }
    .nav li:hover, .nav li.active { background: #1565C0; }
    .btn-logout { margin: 20px; padding: 10px; background: #D32F2F; color: #fff; border: none; cursor: pointer; }
    .main-content { flex: 1; padding: 20px; background: #f5f5f5; overflow-y: auto; }
  `]
})
export class PanelTecnico {
  constructor(private router: Router, private auth: AuthService) {}

  navegarModulo(ruta: string) {
    this.router.navigate(['/tecnico', ruta]);
  }

  logout() {
    this.auth.logout();
  }

  isActive(ruta: string): boolean {
    return this.router.url.includes(ruta);
  }

  get rol(): string | null {
    return this.auth.getRole();
  }
}
