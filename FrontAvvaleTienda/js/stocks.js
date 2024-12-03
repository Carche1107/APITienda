const urlLocal = "http://localhost:8080";
function buscarStocks(){
    let idProducto = document.getElementById("idProducto").value;
    let idColor = document.getElementById("idColor").value;

    fetch (`${urlLocal}/Stock/product?product=${idProducto}&color=${idColor}`,
    {
        method: 'GET',
        mode: 'cors'
    })
    .then(response => response.json())
    .then(data => {
        console.log(data)
        listarStocks(data);
    }).catch(error => console.error('Error al buscar el stock del producto', error));
}

function listarStocks(stocks){
    let Cuerpo = document.getElementById("TableBody");
    Cuerpo.innerHTML = '';
    stocks.forEach(element => {
        let row = document.createElement('tr');
        row.innerHTML = 
        `<td>${element.nombreTienda}</td>
        <td>${element.nombreProducto}</td>
        <td>${element.nombreColor}</td>
        <td>${element.cantidadStock}</td>`;
        Cuerpo.appendChild(row);
    });
}

function cargarProductos(){
    fetch(`${urlLocal}/product`,
        {
            method: 'GET',
            mode: 'cors'
        }
    ).then(response => response.json())
    .then(tiendas => {
        console.log(tiendas);
        let select = document.getElementById("idProducto");
        select.innerHTML = '';
        let defaultOpt = document.createElement("option");
        defaultOpt.value = '';
        defaultOpt.textContent = "Prenda"
        defaultOpt.disabled = true;
        defaultOpt.selected = true;
        select.appendChild(defaultOpt);

        tiendas.forEach(tienda => {
            let opcion = document.createElement("option");
            opcion.value = tienda.idProduct;
            opcion.textContent = tienda.productName;
            select.appendChild(opcion);
        });
    }).catch(error => console.error("Error al cargar los productos", error));
}

function cargarColores(){
    fetch(`${urlLocal}/color`, 
        {
            method: 'GET',
            mode: 'cors'
        }
    ).then(response => response.json())
    .then(tiendas => {
        console.log(tiendas);
        let select = document.getElementById("idColor");
        select.innerHTML = '';
        let defaultOpt = document.createElement("option");
        defaultOpt.value = '';
        defaultOpt.textContent = "Color"
        defaultOpt.disabled = true;
        defaultOpt.selected = true;
        select.appendChild(defaultOpt);

        tiendas.forEach(tienda => {
            let opcion = document.createElement("option");
            opcion.value = tienda.id;
            opcion.textContent = tienda.color;
            select.appendChild(opcion);
        });
    }).catch(error => console.error("Error al cargar los colores", error));
}

window.addEventListener("load", cargarProductos);
window.addEventListener("load", cargarColores);