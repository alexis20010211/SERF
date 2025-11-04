export class ProductosClientePage {
    private container: HTMLElement;
    private productos = [
        { id: 1, nombre: 'Producto A', precio: 50 },
        { id: 2, nombre: 'Producto B', precio: 75 },
        { id: 3, nombre: 'Producto C', precio: 30 },
    ];

    constructor() {
        this.container = document.createElement('div');
    }

    render() {
        let html = `<h1>Productos Disponibles</h1><div class="productos-grid">`;
        this.productos.forEach(p => {
            html += `
                <div class="producto-card">
                    <h3>${p.nombre}</h3>
                    <p>Precio: $${p.precio}</p>
                    <button>Agregar al carrito</button>
                </div>
            `;
        });
        html += `</div>`;
        this.container.innerHTML = html;
        return this.container;
    }
}
