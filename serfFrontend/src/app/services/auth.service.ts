import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private userRole: 'Administrador' | 'Filial' | null = null;

  constructor() {}

  // Llamar después del login
  setRole(role: 'Administrador' | 'Filial') {
    this.userRole = role;
    localStorage.setItem('userRole', role); // opcional para persistir sesión
  }

  getRole(): 'Administrador' | 'Filial' | null {
    // Lee de localStorage si quieres persistencia
    if (!this.userRole) {
      const storedRole = localStorage.getItem('userRole');
      if (storedRole === 'Administrador' || storedRole === 'Filial') {
        this.userRole = storedRole;
      }
    }
    return this.userRole;
  }

  isAdmin(): boolean {
    return this.getRole() === 'Administrador';
  }

  isFilial(): boolean {
    return this.getRole() === 'Filial';
  }

  logout() {
    this.userRole = null;
    localStorage.removeItem('userRole');
  }
}
