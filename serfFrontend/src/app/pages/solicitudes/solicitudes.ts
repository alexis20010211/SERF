import { Component } from '@angular/core';
import { CommonModule, NgIf, NgFor } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';

@Component({
  selector: 'app-solicitudes',
  standalone: true,
  imports: [CommonModule, FormsModule, NgIf, NgFor],
  templateUrl: './solicitudes.html',
  styleUrls: ['./solicitudes.css']
})
export class Solicitudes {
  clientes = [
    { id: 1, nombre: 'Juan Perez' },
    { id: 2, nombre: 'Maria Gomez' }
  ];

  tecnicos = [
    { id: 1, nombre: 'Técnico A' },
    { id: 2, nombre: 'Técnico B' }
  ];

  solicitudes: any[] = [];

  submitted = false;
  nuevaSolicitud = { clienteId: '', tecnicoId: '', detalle: '', fecha: '' };

  registrarSolicitud(form: NgForm) {
    this.submitted = true;
    if (form.valid) {
      const cliente = this.clientes.find(c => c.id === +this.nuevaSolicitud.clienteId);
      const tecnico = this.tecnicos.find(t => t.id === +this.nuevaSolicitud.tecnicoId);
      const fecha = new Date().toLocaleDateString();

      this.solicitudes.push({
        cliente: cliente?.nombre,
        tecnico: tecnico?.nombre,
        detalle: this.nuevaSolicitud.detalle,
        fecha: fecha,
        estado: 'Pendiente'
      });

      // reset formulario
      this.nuevaSolicitud = { clienteId: '', tecnicoId: '', detalle: '', fecha: '' };
      form.resetForm();
      this.submitted = false;
    }
  }

  cambiarEstado(solicitud: any) {
    const estados = ['Pendiente', 'En proceso', 'Resuelta'];
    const idx = estados.indexOf(solicitud.estado);
    solicitud.estado = estados[(idx + 1) % estados.length];
  }
}
