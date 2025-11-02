import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private userRole: 'Administrador' | 'Filial' | null = null;

  constructor() {
    // ✅ Si hay datos en localStorage, los cargamos al iniciar
    const storedRole = localStorage.getItem('userRole');
    if (storedRole === 'Administrador' || storedRole === 'Filial') {
      this.userRole = storedRole;
    }
  }

  // ✅ Guarda el rol y marca como logueado
  login(role: 'Administrador' | 'Filial') {
    this.userRole = role;
    localStorage.setItem('userRole', role);
    localStorage.setItem('loggedIn', 'true');
  }

  // ✅ Devuelve el rol actual
  getRole(): 'Administrador' | 'Filial' | null {
    if (!this.userRole) {
      const storedRole = localStorage.getItem('userRole');
      if (storedRole === 'Administrador' || storedRole === 'Filial') {
        this.userRole = storedRole;
      }
    }
    return this.userRole;
  }

  // ✅ Verifica si está logueado
  isLoggedIn(): boolean {
    const logged = localStorage.getItem('loggedIn');
    const role = localStorage.getItem('userRole');
    return logged === 'true' && (role === 'Administrador' || role === 'Filial');
  }

  // ✅ Cierra sesión completamente
  logout() {
    this.userRole = null;
    localStorage.removeItem('userRole');
    localStorage.removeItem('loggedIn');
  }
}
