import { Routes } from '@angular/router';

// 🔹 Servicios y Guards
import { AuthGuard } from './services/auth.guard';

// 🔹 Páginas generales (standalone)
import { Login } from './pages/login/login';
import { Productos } from './pages/productos/productos';
import { Ventas } from './pages/ventas/ventas';
import { Reportes } from './pages/reportes/reportes';
import { Clientes } from './pages/clientes/clientes';
import { Tecnico } from './pages/tecnico/tecnico';
import { Solicitudes } from './pages/solicitudes/solicitudes';
import { Configuracion } from './pages/configuracion/configuracion';

// 🔹 Admin pages
import { AdminPanel } from './pages/roles/admin/admin-panel/admin-panel';
import { DashboardAdmin } from './pages/roles/admin/dashboard-admin/dashboard-admin';
import { Usuarios } from './pages/roles/admin/gestion-usuarios/gestion-usuarios';
import { ReportesAdmin } from './pages/roles/admin/reportes-admin/reportes-admin';

// 🔹 Filial pages
import { PanelFilial } from './pages/roles/filial/panel-filial/panel-filial'; // ✅ Nuevo contenedor
import { DashboardFilial } from './pages/roles/filial/dashboard-filial/dashboard-filial';
import { ClientesFilial } from './pages/roles/filial/clientes/clientes';
import { VentasFilial } from './pages/roles/filial/ventas/ventas';

export const appRoutes: Routes = [
  // 🔹 Página inicial (Login)
  { path: '', component: Login, pathMatch: 'full' },

  // 🔹 ADMINISTRADOR (protegido por rol)
  {
    path: 'admin',
    component: AdminPanel,
    canActivate: [AuthGuard],
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

  // 🔹 FILIAL (protegido por rol)
  {
    path: 'filial',
    component: PanelFilial, // ✅ Nuevo contenedor con <router-outlet>
    canActivate: [AuthGuard],
    data: { role: 'Filial' },
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
      { path: 'dashboard', component: DashboardFilial },
      { path: 'ventas', component: VentasFilial },
      { path: 'reportes', component: Reportes },
      { path: 'clientes', component: ClientesFilial },
    ]
  },

  // 🔹 Cualquier ruta no válida → Login
  { path: '**', redirectTo: '', pathMatch: 'full' }
];
