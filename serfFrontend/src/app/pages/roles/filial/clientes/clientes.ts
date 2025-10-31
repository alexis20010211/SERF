import { Component } from '@angular/core';
import { CommonModule, NgFor, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-clientes-filial',
  standalone: true,
  imports: [CommonModule, FormsModule, NgIf, NgFor],
  templateUrl: './clientes.html',
  styleUrls: ['./clientes.css']
})
export class ClientesFilial {
  cliente = { nombre: '', email: '', telefono: '' };
  clientes: any[] = [];
  submitted = false;
  clienteRegistrado = false;

  registrarCliente() {
    this.submitted = true;
    if (this.cliente.nombre && this.cliente.email) {
      this.clientes.push({ ...this.cliente });
      this.cliente = { nombre: '', email: '', telefono: '' };
      this.clienteRegistrado = true;
      setTimeout(() => this.clienteRegistrado = false, 2000);
    }
  }
}
