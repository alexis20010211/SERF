export class PlantillaReporte {
  titulo = 'Plantilla';
  secciones: any[] = [];
  clone(): PlantillaReporte {
    const copia = new PlantillaReporte();
    copia.titulo = this.titulo;
    copia.secciones = JSON.parse(JSON.stringify(this.secciones));
    return copia;
  }
}
