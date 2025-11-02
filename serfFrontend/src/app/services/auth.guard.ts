import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from './auth.service';

export const AuthGuard: CanActivateFn = (route, state) => {
  const auth = inject(AuthService);
  const router = inject(Router);

  // ✅ 1. Si no está logueado, lo mandamos al login (ruta raíz)
  if (!auth.isLoggedIn()) {
    router.navigate(['']);
    return false;
  }

  // ✅ 2. Revisar el rol actual
  const requiredRole = route.data['role'] as 'Administrador' | 'Filial' | undefined;
  const currentRole = auth.getRole();

  // 🔸 Si la ruta requiere un rol y el usuario tiene otro → redirigir a su dashboard
  if (requiredRole && currentRole !== requiredRole) {
    if (currentRole === 'Administrador') {
      router.navigate(['/admin']);
    } else if (currentRole === 'Filial') {
      router.navigate(['/filial']);
    } else {
      router.navigate(['']);
    }
    return false;
  }

  // ✅ 3. Todo correcto → permitir acceso
  return true;
};
