import { Routes } from '@angular/router';

// 🔹 Páginas generales (standalone)
import { Login } from './pages/login/login';
import { Productos } from './pages/productos/productos';
import { Ventas } from './pages/ventas/ventas';
import { Reportes } from './pages/reportes/reportes';
import { Clientes } from './pages/clientes/clientes';
import { Tecnico } from './pages/tecnico/tecnico';
import { Solicitudes } from './pages/solicitudes/solicitudes';
import { Configuracion } from './pages/configuracion/configuracion';

// 🔹 Dashboard principal del administrador
import { DashboardAdmin } from './pages/roles/admin/dashboard-admin/dashboard-admin';

// 🔹 Admin pages
import { AdminPanel } from './pages/roles/admin/admin-panel/admin-panel';
import { Usuarios } from './pages/roles/admin/gestion-usuarios/gestion-usuarios';
import { ReportesAdmin } from './pages/roles/admin/reportes-admin/reportes-admin';

// 🔹 Filial pages
import { DashboardFilial } from './pages/roles/filial/dashboard-filial/dashboard-filial';
import { ClientesFilial } from './pages/roles/filial/clientes/clientes';
import { VentasFilial } from './pages/roles/filial/ventas/ventas';

export const appRoutes: Routes = [
  // 🔹 Página inicial (Login)
  { path: '', component: Login, pathMatch: 'full' },

  // 🔹 Rutas para ADMINISTRADOR
  {
    path: 'admin',
    component: AdminPanel,
    children: [
      { path: '', component: DashboardAdmin },              // ✅ Dashboard principal del admin
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

  // 🔹 Rutas para FILIAL
  {
    path: 'filial',
    component: DashboardFilial,
    children: [
      { path: '', redirectTo: 'ventas', pathMatch: 'full' }, // redirige a ventas
      { path: 'ventas', component: VentasFilial },
      { path: 'reportes', component: Reportes },
      { path: 'clientes', component: ClientesFilial },
    ]
  },

  // 🔹 RUTA POR DEFECTO (fallback)
  { path: '**', redirectTo: '', pathMatch: 'full' }
];
