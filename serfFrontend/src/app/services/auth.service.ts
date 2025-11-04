// src/app/services/auth.service.ts
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private router: Router) {}

  login(email: string, password: string): boolean {
    const users = [
      { email: 'admin@financorp.com', password: 'admin123', rol: 'Administrador' },
      { email: 'filial@financorp.com', password: 'filial123', rol: 'Filial' },
      { email: 'tecnico@financorp.com', password: 'tecnico123', rol: 'Tecnico' },
      { email: 'cliente@financorp.com', password: 'cliente123', rol: 'Cliente' }
    ];

    const user = users.find(u => u.email === email && u.password === password);

    if (user) {
      localStorage.setItem('isLoggedIn', 'true');
      localStorage.setItem('role', user.rol);
      localStorage.setItem('email', user.email);
      return true;
    }

    return false;
  }

  logout(): void {
    localStorage.clear();
    this.router.navigate(['']);
  }

  isLoggedIn(): boolean {
    return localStorage.getItem('isLoggedIn') === 'true';
  }

  getRole(): string | null {
    return localStorage.getItem('role');
  }

  getEmail(): string | null {
    return localStorage.getItem('email');
  }
}
