export class ConfiguracionGlobal {
  private static instance: ConfiguracionGlobal;
  moneda = 'EUR';
  formatoFecha = 'dd/MM/yyyy';
  constructor() { /* leer localStorage o backend si se quiere */ }
  static getInstance() {
    if (!ConfiguracionGlobal.instance) ConfiguracionGlobal.instance = new ConfiguracionGlobal();
    return ConfiguracionGlobal.instance;
  }
}
