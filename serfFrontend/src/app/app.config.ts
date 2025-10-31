// ===============================================================
// 🌐 Configuración global de la aplicación Angular
// Define los proveedores principales: ruteo, HTTP y animaciones.
// ===============================================================

import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { provideAnimations } from '@angular/platform-browser/animations';
import { appRoutes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    // ✅ Ruteo principal
    provideRouter(appRoutes),

    // ✅ Cliente HTTP global (permite hacer peticiones al backend)
    // Puedes agregar interceptores globales (por ejemplo para Auth)
    provideHttpClient(withInterceptorsFromDi()),

    // ✅ Animaciones de Angular Material u otros componentes
    provideAnimations(),
  ]
};
