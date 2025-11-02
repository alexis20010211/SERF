export interface SolicitudDTO {
    id: number;
    tipo: 'Financiera' | 'Tecnica' | 'Ventas';
    descripcion: string;
    fecha: string; // ISO date string
}

