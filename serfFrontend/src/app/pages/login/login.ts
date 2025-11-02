import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './login.html',
  styleUrls: ['./login.css']
})
export class Login implements OnInit {
  loginForm: FormGroup;
  submitted = false;
  loginError = '';

  roles = ['Administrador', 'Filial'];

  // 🔹 Usuarios de ejemplo
  demoUsers = [
    { email: 'admin@financorp.com', password: 'admin123', role: 'Administrador' },
    { email: 'filial@financorp.com', password: 'filial123', role: 'Filial' }
  ];

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private auth: AuthService
  ) {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      role: ['', Validators.required]
    });
  }

  get f() {
    return this.loginForm.controls;
  }

  ngOnInit() {
    // 🔹 Si ya hay sesión activa → redirigir automáticamente
    if (this.auth.isLoggedIn()) {
      const role = this.auth.getRole();
      if (role === 'Administrador') {
        this.router.navigate(['/admin'], { replaceUrl: true });
      } else if (role === 'Filial') {
        this.router.navigate(['/filial'], { replaceUrl: true });
      }
    } else {
      // Limpia cualquier sesión anterior
      this.auth.logout();
    }

    // 🔹 Animación visual
    setTimeout(() => {
      document.querySelector('.login-container')?.classList.add('loaded');
    }, 100);
  }

  onSubmit() {
    this.submitted = true;
    this.loginError = '';

    if (this.loginForm.invalid) return;

    const { username, password, role } = this.loginForm.value;

    // 🔹 Validar credenciales (demo)
    const validUser = this.demoUsers.find(
      user => user.email === username && user.password === password && user.role === role
    );

    if (validUser) {
      // ✅ Guardar sesión y rol
      this.auth.login(role);

      // 🔹 Redirigir según el rol
      if (role === 'Administrador') {
        this.router.navigate(['/admin'], { replaceUrl: true });
      } else if (role === 'Filial') {
        this.router.navigate(['/filial'], { replaceUrl: true });
      }
    } else {
      this.loginError = 'Usuario, contraseña o rol incorrecto';
    }
  }
}
