export interface VentaDTO {
  id?: number;
  clienteId: number;
  productoId: number;
  cantidad: number;
  total: number;
  fecha: string;
}
