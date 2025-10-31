import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonModule, NgIf } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { ProductosService } from '../../services/productos.service'; // ✅ Importar el servicio real
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-producto',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, NgIf],
  templateUrl: './productos.html',
  styleUrls: ['./productos.css']
})
export class Productos {
  productoForm: FormGroup;
  submitted = false;
  productoRegistrado = false;
  cargando = false; // ✅ para mostrar spinner si deseas
  categorias = ['Laptop', 'Smartphone', 'Accesorio', 'Equipo de red'];
  proveedores = ['Proveedor A', 'Proveedor B', 'Proveedor C'];

  constructor(
    private fb: FormBuilder,
    private productosService: ProductosService, // ✅ usar el servicio HTTP
    private auth: AuthService
  ) {
    this.productoForm = this.fb.group({
      codigo: ['', Validators.required],
      nombre: ['', Validators.required],
      descripcion: ['', Validators.required],
      categoria: ['', Validators.required],
      costoImportacion: ['', [Validators.required, Validators.min(0)]],
      precioVenta: ['', [Validators.required, Validators.min(0)]],
      proveedor: ['', Validators.required],
      fechaImportacion: ['', Validators.required],
      stockInicial: ['', [Validators.required, Validators.min(0)]]
    });
  }

  get f() {
    return this.productoForm.controls;
  }

  get isAdmin(): boolean {
    return this.auth.getRole() === 'Administrador';
  }

  async onSubmit() {
    this.submitted = true;

    if (!this.isAdmin) {
      alert('Solo los administradores pueden registrar productos.');
      return;
    }

    if (this.productoForm.invalid) return;

    this.cargando = true;

    try {
      // ✅ Enviar los datos al backend
      const nuevoProducto = await this.productosService.create(this.productoForm.value);
      console.log('Producto registrado:', nuevoProducto);

      this.productoRegistrado = true;
      setTimeout(() => (this.productoRegistrado = false), 3000);

      this.productoForm.reset();
      this.submitted = false;
    } catch (error) {
      console.error('Error al registrar el producto:', error);
      alert('❌ Ocurrió un error al registrar el producto. Revisa la consola.');
    } finally {
      this.cargando = false;
    }
  }
}
