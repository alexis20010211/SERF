// ===============================================================
// 🌐 app.routes.ts — Rutas principales del sistema FINANCORP
// Configura la navegación global para todos los roles del sistema
// ===============================================================

import { Routes } from '@angular/router';

// 🌍 Páginas generales (standalone)
import { Login } from './pages/login/login';
import { Productos } from './pages/productos/productos';
import { Ventas } from './pages/ventas/ventas';
import { Reportes } from './pages/reportes/reportes';
import { Clientes } from './pages/clientes/clientes';
import { Tecnico } from './pages/tecnico/tecnico';
import { Solicitudes } from './pages/solicitudes/solicitudes';
import { Configuracion } from './pages/configuracion/configuracion';

// 🧩 ADMINISTRADOR
import { AdminPanel } from './pages/roles/admin/admin-panel/admin-panel';
import { DashboardAdmin } from './pages/roles/admin/dashboard-admin/dashboard-admin';
import { Usuarios } from './pages/roles/admin/gestion-usuarios/gestion-usuarios';
import { ReportesAdmin } from './pages/roles/admin/reportes-admin/reportes-admin';

// 🧩 FILIAL
import { PanelFilial } from './pages/roles/filial/panel-filial/panel-filial';
import { DashboardFilial } from './pages/roles/filial/dashboard-filial/dashboard-filial';
import { ClientesFilial } from './pages/roles/filial/clientes/clientes';
import { VentasFilial } from './pages/roles/filial/ventas/ventas';

// 🧩 TÉCNICO
import { PanelTecnico } from './pages/roles/tecnico/panel-tecnico/panel-tecnico';
import { DashboardTecnicoComponent } from './pages/roles/tecnico/dashboard-tecnico/dashboard-tecnico';
import { SolicitudesTecnicoPage } from './pages/roles/tecnico/solicitudes-tecnico/solicitudes-tecnico';

// 🧩 CLIENTE
import { PanelCliente } from './pages/roles/cliente/panel-cliente/panel-cliente';
import { DashboardClienteComponent } from './pages/roles/cliente/dashboard-cliente/dashboard-cliente';
import { ProductosClientePage } from './pages/roles/cliente/productos-cliente/productos-cliente';

// ===============================================================
// 🌍 DEFINICIÓN DE RUTAS (SIN AuthGuard)
// ===============================================================

export const appRoutes: Routes = [

  // LOGIN
  { path: '', component: Login, pathMatch: 'full' },

  // ADMINISTRADOR
  {
    path: 'admin',
    component: AdminPanel,
    data: { role: 'Administrador' },
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
      { path: 'dashboard', component: DashboardAdmin },
      { path: 'productos', component: Productos },
      { path: 'ventas', component: Ventas },
      { path: 'reportes', component: ReportesAdmin },
      { path: 'clientes', component: Clientes },
      { path: 'tecnicos', component: Tecnico },
      { path: 'solicitudes', component: Solicitudes },
      { path: 'gestion-usuarios', component: Usuarios },
      { path: 'configuracion', component: Configuracion },
    ]
  },

  // FILIAL
  {
    path: 'filial',
    component: PanelFilial,
    data: { role: 'Filial' },
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
      { path: 'dashboard', component: DashboardFilial },
      { path: 'ventas', component: VentasFilial },
      { path: 'clientes', component: ClientesFilial },
      { path: 'reportes', component: Reportes },
    ]
  },

  // TÉCNICO
  {
    path: 'tecnico',
    component: PanelTecnico,
    data: { role: 'Tecnico' },
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
      { path: 'dashboard', component: DashboardTecnicoComponent },
      { path: 'solicitudes', component: SolicitudesTecnicoPage },
    ]
  },

  // CLIENTE
  {
    path: 'cliente',
    component: PanelCliente,
    data: { role: 'Cliente' },
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
      { path: 'dashboard', component: DashboardClienteComponent },
      { path: 'productos', component: ProductosClientePage },
    ]
  },

  // RUTA POR DEFECTO
  { path: '**', redirectTo: '', pathMatch: 'full' }
];
