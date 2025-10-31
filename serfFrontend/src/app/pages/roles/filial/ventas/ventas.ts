import { Component } from '@angular/core';
import { CommonModule, NgFor, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-ventas-filial',
  standalone: true,
  imports: [CommonModule, FormsModule, NgIf, NgFor],
  templateUrl: './ventas.html',
  styleUrls: ['./ventas.css']
})
export class VentasFilial {
  venta = { factura: '', producto: '', cantidad: 1, total: 0 };
  ventas: any[] = [];
  submitted = false;

  registrarVenta() {
    this.submitted = true;
    if (this.venta.factura && this.venta.producto) {
      this.ventas.push({ ...this.venta });
      this.venta = { factura: '', producto: '', cantidad: 1, total: 0 };
    }
  }
}
