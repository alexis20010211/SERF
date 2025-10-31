import { bootstrapApplication } from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http';
import { provideRouter } from '@angular/router';
import { appRoutes } from './app/app.routes';
import { App } from './app/app'; // ✅ Componente raíz correcto

bootstrapApplication(App, {
  providers: [
    provideRouter(appRoutes),
    provideHttpClient()
  ]
}).catch(err => console.error(err));
