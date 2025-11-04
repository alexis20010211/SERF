import { Component } from '@angular/core';
import { CommonModule, NgFor } from '@angular/common';
import { RouterModule, Router, RouterOutlet } from '@angular/router';
import { AuthService } from '../../../../services/auth.service';

@Component({
  selector: 'app-admin-panel',
  standalone: true,
  imports: [CommonModule, NgFor, RouterModule, RouterOutlet],
  template: `
  <div class="admin-container">
    <!-- Sidebar -->
    <aside class="sidebar">
      <div class="brand">
        <div class="brand-logo">FINANCORP</div>
        <div class="brand-sub">Administrador</div>
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
    </main>
  </div>
  `,
  styles: [`
    .admin-container { display: flex; height: 100vh; font-family: Arial, sans-serif; }
    .sidebar { width: 220px; background: #0D47A1; color: #fff; display: flex; flex-direction: column; justify-content: space-between; transition: all 0.3s ease; }
    .sidebar:hover { width: 240px; }
    .brand { padding: 20px; text-align: center; }
    .brand-logo { font-size: 1.5em; font-weight: bold; }
    .brand-sub { font-size: 0.9em; margin-top: 5px; }
    .nav ul { list-style: none; padding: 0; margin: 0; }
    .nav li { padding: 15px 20px; cursor: pointer; transition: 0.3s; border-radius: 5px; }
    .nav li:hover, .nav li.active { background: #1565C0; transform: translateX(5px); }
    .btn-logout { margin: 20px; padding: 10px; background: #D32F2F; color: #fff; border: none; cursor: pointer; border-radius: 5px; transition: 0.3s; font-weight:bold; }
    .btn-logout:hover { background: #B71C1C; transform: scale(1.05); }
    .main-content { flex: 1; padding: 20px; background: #f5f5f5; overflow-y: auto; }
  `]
})
export class AdminPanel {
  modulos = [
    { nombre: 'Dashboard', ruta: 'dashboard' },
    { nombre: 'Productos', ruta: 'productos' },
    { nombre: 'Usuarios', ruta: 'gestion-usuarios' },
    { nombre: 'Clientes', ruta: 'clientes' },
    { nombre: 'Ventas', ruta: 'ventas' },
    { nombre: 'Reportes', ruta: 'reportes' },
    { nombre: 'Técnicos', ruta: 'tecnicos' },
    { nombre: 'Solicitudes', ruta: 'solicitudes' },
    { nombre: 'Configuración', ruta: 'configuracion' },
  ];

  constructor(private router: Router, private auth: AuthService) {}

  navegarModulo(ruta: string) {
    this.router.navigate(['/admin', ruta]);
  }

  logout() {
    this.auth.logout();
    this.router.navigate(['/']); 
  }

  isActive(ruta: string): boolean {
    return this.router.url.includes(ruta);
  }

  get rol(): string | null {
    return this.auth.getRole();
  }
}
