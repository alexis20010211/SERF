import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule, NgFor } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AuthService } from '../../../../services/auth.service'; // ✅ asegúrate de tener este servicio

@Component({
  selector: 'app-admin-panel',
  standalone: true,
  imports: [
    CommonModule,
    NgFor,
    RouterModule
  ],
  templateUrl: './admin-panel.html',
  styleUrls: ['./admin-panel.css']
})
export class AdminPanel {

  // ✅ Lista de módulos para el menú lateral
  modulos = [
    { nombre: 'Dashboard', ruta: '' },
    { nombre: 'Ventas', ruta: 'ventas' },
    { nombre: 'Reportes', ruta: 'reportes' },
    { nombre: 'Productos', ruta: 'productos' },
    { nombre: 'Clientes', ruta: 'clientes' },
    { nombre: 'Técnicos', ruta: 'tecnicos' },
    { nombre: 'Solicitudes', ruta: 'solicitudes' },
    { nombre: 'Gestión de Usuarios', ruta: 'gestion-usuarios' },
    { nombre: 'Configuración', ruta: 'configuracion' },
  ];

  constructor(
    private router: Router,
    private auth: AuthService // ✅ Inyectamos AuthService
  ) {}

  // ✅ Navegación programática (opcional)
  navegarModulo(ruta: string) {
    this.router.navigate(['/admin', ruta]);
  }

  // ✅ Limpieza visual (si se usa)
  formatearStatus(status: string): string {
    return status.toLowerCase().replace(/ /g, '-');
  }

  // ✅ Cerrar sesión
  logout() {
    this.auth.logout();          // Limpia sesión/token
    this.router.navigate(['/']); // Redirige al login
  }
}
