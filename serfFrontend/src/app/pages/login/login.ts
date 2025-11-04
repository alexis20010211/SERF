import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './login.html',
  styleUrls: ['./login.css']
})
export class Login {
  loginForm: FormGroup;
  errorMessage: string = '';

  private users = [
    { email: 'admin@financorp.com', password: 'admin123', rol: 'Administrador', redirect: '/admin/dashboard' },
    { email: 'filial@financorp.com', password: 'filial123', rol: 'Filial', redirect: '/filial/dashboard' },
    { email: 'tecnico@financorp.com', password: 'tecnico123', rol: 'Tecnico', redirect: '/tecnico/dashboard' },
    { email: 'cliente@financorp.com', password: 'cliente123', rol: 'Cliente', redirect: '/cliente/dashboard' }
  ];

  constructor(private fb: FormBuilder, private router: Router) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      rol: ['', Validators.required]
    });
  }

  login() {
    if (!this.loginForm.valid) {
      this.loginForm.markAllAsTouched();
      this.errorMessage = '⚠️ Complete todos los campos.';
      return;
    }

    const { email, password, rol } = this.loginForm.value;

    const user = this.users.find(u =>
      u.email.toLowerCase() === email.toLowerCase() &&
      u.password === password &&
      u.rol === rol
    );

    if (user) {
      localStorage.setItem('user', JSON.stringify({ email: user.email, role: user.rol }));
      this.router.navigate([user.redirect]);
    } else {
      this.errorMessage = '❌ Correo, contraseña o rol incorrectos.';
    }
  }
}
