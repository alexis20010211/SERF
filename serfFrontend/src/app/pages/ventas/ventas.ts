import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule, NgIf, NgFor } from '@angular/common';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-ventas',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, NgIf, NgFor],
  templateUrl: './ventas.html',
  styleUrls: ['./ventas.css']
})
export class Ventas {
  ventasForm: FormGroup;
  submitted = false;
  ventaRegistrada: any = null;
  mostrarMensaje = false;

  // Lista de productos con stock
  productos = [
    { id: 1, nombre: 'Laptop X', precio: 1200, stock: 10 },
    { id: 2, nombre: 'Smartphone Y', precio: 800, stock: 20 },
    { id: 3, nombre: 'Accesorio Z', precio: 50, stock: 50 }
  ];

  metodosPago = ['Efectivo', 'Tarjeta', 'Transferencia'];

  constructor(private fb: FormBuilder, private auth: AuthService) {
    this.ventasForm = this.fb.group({
      numeroFactura: ['', Validators.required],
      fechaVenta: ['', Validators.required],
      producto: ['', Validators.required],
      cantidad: ['', [Validators.required, Validators.min(1)]],
      precioUnitario: [{ value: '', disabled: true }, Validators.required],
      cliente: ['', Validators.required],
      vendedor: ['', Validators.required],
      metodoPago: ['', Validators.required]
    });
  }

  // Getter para acceso fácil desde HTML
  get f() {
    return this.ventasForm.controls;
  }

  // Control de rol: solo Admin o Filial pueden registrar
  get canRegister(): boolean {
    const role = this.auth.getRole();
    return role === 'Administrador' || role === 'Filial';
  }

  // Actualiza precio al cambiar producto
  onProductoChange() {
    const selectedId = this.ventasForm.value.producto;
    const producto = this.productos.find(p => p.id == selectedId);
    if (producto) {
      this.ventasForm.patchValue({ precioUnitario: producto.precio });
    } else {
      this.ventasForm.patchValue({ precioUnitario: '' });
    }
  }

  onSubmit() {
    this.submitted = true;

    if (!this.canRegister) {
      alert('No tienes permisos para registrar ventas.');
      return;
    }

    if (this.ventasForm.invalid) return;

    const venta = { ...this.ventasForm.getRawValue() };
    const producto = this.productos.find(p => p.id == venta.producto);

    if (producto && producto.stock >= venta.cantidad) {
      // Actualiza stock
      producto.stock -= venta.cantidad;

      this.ventaRegistrada = venta;
      this.mostrarMensaje = true;

      // Reinicia formulario
      this.ventasForm.reset();
      this.submitted = false;

      // Oculta mensaje después de 3 segundos
      setTimeout(() => this.mostrarMensaje = false, 3000);
    } else {
      alert('Stock insuficiente para el producto seleccionado.');
    }
  }
}
