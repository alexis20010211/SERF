import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

// ✅ Importamos los componentes standalone
import { Layout } from './layout/layout';
import { Dashboard } from './dashboard/dashboard';
import { Login } from './login/login';
import { Productos } from './productos/productos';
import { Ventas } from './ventas/ventas';
import { Reportes } from './reportes/reportes';
import { Configuracion } from './configuracion/configuracion';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule,

    // ✅ Standalone components importados directamente
    Layout,
    Dashboard,
    Login,
    Productos,
    Ventas,
    Reportes,
    Configuracion
  ],
  exports: [
    Layout,
    Dashboard,
    Login,
    Productos,
    Ventas,
    Reportes,
    Configuracion
  ]
})
export class PagesModule {}
