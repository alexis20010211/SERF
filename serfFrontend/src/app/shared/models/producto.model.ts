// shared/models/producto.model.ts
export interface Producto {
  id: number;
  nombre: string;
  precio: number;
  categoria?: string;
}
