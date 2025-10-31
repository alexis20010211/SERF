import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-layout',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './layout.html',
  styleUrls: ['./layout.css']
})
export class Layout {
  collapsed = false;

  constructor(public auth: AuthService) {} // AuthService público para usarlo en el HTML

  toggle() {
    this.collapsed = !this.collapsed;
  }
}
