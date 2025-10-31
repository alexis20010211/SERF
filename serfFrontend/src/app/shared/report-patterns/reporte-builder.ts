export class ReporteBuilder {
  reporte: any;
  start(titulo:string){
    this.reporte = { titulo, encabezado: {}, cuerpo: [], firma: null, watermark: null };
    return this;
  }
  withEncabezado(enc:any){ this.reporte.encabezado = enc; return this; }
  addSeccion(sec:any){ this.reporte.cuerpo.push(sec); return this; }
  withFirma(firma:any){ this.reporte.firma = firma; return this; }
  withWatermark(wm:any){ this.reporte.watermark = wm; return this; }
  build(){ return this.reporte; }
}
