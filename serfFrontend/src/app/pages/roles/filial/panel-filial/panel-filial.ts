import { Component } from '@angular/core';
import { RouterOutlet, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../../../services/auth.service';

@Component({
  selector: 'app-panel-filial',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  templateUrl: './panel-filial.html',
  styleUrls: ['./panel-filial.css']
})
export class PanelFilial {

  constructor(
    private auth: AuthService,
    private router: Router
  ) {}

  // 🔹 Cierra sesión y redirige al login
  logout() {
    this.auth.logout();
    this.router.navigate(['']);
  }
}
