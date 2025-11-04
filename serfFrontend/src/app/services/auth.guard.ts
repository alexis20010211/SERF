import { Injectable, inject } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  private auth = inject(AuthService);
  private router = inject(Router);

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const currentRole = this.auth.getRole(); // Puede ser string o null
    const requiredRole = route.data['role'] as string;

    // 🔹 No hay sesión → ir al login
    if (!this.auth.isLoggedIn()) {
      this.router.navigate(['']);
      return false;
    }

    // 🔹 Rol ausente o incorrecto → redirigir al dashboard de su rol (si existe)
    if (!currentRole || (requiredRole && currentRole !== requiredRole)) {
      this.redirectToRoleDashboard(currentRole ?? '');
      return false;
    }

    // ✅ Acceso permitido
    return true;
  }

  // 🔹 Redirigir según rol
  private redirectToRoleDashboard(role: string): void {
    switch (role) {
      case 'Administrador':
        this.router.navigate(['/admin/dashboard']);
        break;
      case 'Filial':
        this.router.navigate(['/filial/dashboard']);
        break;
      case 'Tecnico':
        this.router.navigate(['/tecnico/dashboard']);
        break;
      case 'Cliente':
        this.router.navigate(['/cliente/dashboard']);
        break;
      default:
        this.router.navigate(['']);
        break;
    }
  }
}
