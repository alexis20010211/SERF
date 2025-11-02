export interface ReporteDTO {
    tipo: 'General' | 'Ventas' | 'Inventario' | 'Financiero';
    contenido: string;
}
